package com.gavin.pipi.mqtt;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author wangguoqiang
 * @date 2020/3/16 15:13
 */
public class RequestResponse {
    public static void main(final String[] args) {
        final Mqtt5Client requester = Mqtt5Client.builder().serverHost("182.61.11.118").serverPort(1883).build();
        final Mqtt5Client responder = Mqtt5Client.builder().serverHost("182.61.11.118").serverPort(1883).build();

        requester.toBlocking().connect();
        responder.toBlocking().connect();

        responder.toRx()
                .publish(responder.toRx()
                        .subscribeStreamWith()
                        .topicFilter("request/topic")
                        .applySubscribe()
                        .map(requestPublish -> {
                            byte[] requestMsgBytes = requestPublish.getPayloadAsBytes();
                            System.out.printf("收到客户端的请求消息：[%s]\n",new String(requestMsgBytes));
                            ByteBuffer byteBuffer = requestPublish.getCorrelationData().orElse(null);
                            if(byteBuffer != null){
                                System.out.printf("收到客户端的附带的相关内容:[%s]\n",getString(byteBuffer));
                            }
                            String respongseMsg = "这是要查询的结果:司机的信息";
                            return Mqtt5Publish.builder()
                                .topic(requestPublish.getResponseTopic().get())
                                .qos(requestPublish.getQos())
                                .payload(respongseMsg.getBytes())
                                .correlationData(requestPublish.getCorrelationData().orElse(null))
                                .build();
                        }))
                .subscribe(); // this call is a reactive streams subscribe call, not an MQTT subscribe

        requester.toAsync()
                .subscribeWith()
                .topicFilter("response/topic")
                .callback(responsePublish -> {
                    byte[] payloadAsBytes = responsePublish.getPayloadAsBytes();
                    System.out.println(new String(payloadAsBytes));
                })
                .send()
                .thenCompose(subAck -> requester.toAsync()
                        .publishWith()
                        .topic("request/topic")
                        .responseTopic("response/topic")
                        .correlationData("司机id：909ee2342dff".getBytes())
                        .qos(MqttQos.EXACTLY_ONCE)
                        .payload("查询司机的消息".getBytes())
                        .send());
    }

    /**
     * ByteBuffer 转换 String
     * @param buffer
     * @return
     */
    public static String getString(ByteBuffer buffer)
    {
        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;
        try
        {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            return charBuffer.toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }
}
