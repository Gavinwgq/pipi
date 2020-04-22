package com.gavin.pipi.mqtt;

import com.hivemq.client.mqtt.MqttGlobalPublishFilter;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import java.util.concurrent.TimeUnit;

/**
 * @author wangguoqiang
 * @date 2020/4/22 11:37
 */
public class MqttSub {

    public static void subscribe(String topic, Mqtt5BlockingClient client){
        client.connect();
        try (final Mqtt5BlockingClient.Mqtt5Publishes publishes = client.publishes(MqttGlobalPublishFilter.ALL)) {

            client.subscribeWith().topicFilter(topic).qos(MqttQos.AT_LEAST_ONCE).send();
            while (true){
                publishes.receive(100, TimeUnit.MILLISECONDS).ifPresent(mqtt5Publish ->{
                    byte[] payloadAsBytes = mqtt5Publish.getPayloadAsBytes();
                    System.out.println(new String(payloadAsBytes));
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            client.disconnect();
        }
    }

    public static void main(String[] args) {
        String topic = "test/Gavin";
        Mqtt5BlockingClient client = MqttClientFactory.getClient();
        subscribe(topic,client);
    }
}
