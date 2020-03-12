package com.gavin.pipi.mqtt;

import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.MqttGlobalPublishFilter;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.Mqtt3Client;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangguoqiang
 * @date 2020/3/12 20:48
 */

public class MqttClientFactory {


    public static Mqtt5Client getMqtt5Client(){
        return MqttClient.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("182.61.11.118")
                .serverPort(8083)
                .useMqttVersion5()
                .build();
    }


    public static Mqtt3Client getMqtt3Client(){
        return MqttClient.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("182.61.11.118")
                .serverPort(8083)
                .useMqttVersion3()
                .build();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("推送消息");
        String msg = "hello mqtt!";
        String topic = "test/Gavin";
        //subscribe(topic);
        publish(topic,msg+ RandomStringUtils.random(8));

    }

    public static void subscribe(String topic){
        final Mqtt5BlockingClient client = Mqtt5Client.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("182.61.11.118")
                .serverPort(1883)
                .buildBlocking();
        client.connect();

        try (final Mqtt5BlockingClient.Mqtt5Publishes publishes = client.publishes(MqttGlobalPublishFilter.ALL)) {

            client.subscribeWith().topicFilter(topic).qos(MqttQos.AT_LEAST_ONCE).send();

            publishes.receive(1, TimeUnit.SECONDS).ifPresent(System.out::println);
            publishes.receive(100, TimeUnit.MILLISECONDS).ifPresent(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            client.disconnect();
        }
    }

    public static void publish(String topic,String msg) throws InterruptedException {
        Mqtt5BlockingClient client = Mqtt5Client.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("182.61.11.118")
                .serverPort(1883)
                .buildBlocking();
        client.connect();
        client.publishWith().topic(topic).qos(MqttQos.AT_LEAST_ONCE).payload(msg.getBytes()).send();

        final Mqtt5BlockingClient.Mqtt5Publishes publishes = client.publishes(MqttGlobalPublishFilter.ALL);
        client.subscribeWith().topicFilter(topic).qos(MqttQos.AT_LEAST_ONCE).send();
        publishes.receive(1, TimeUnit.SECONDS).ifPresent(System.out::println);
        publishes.receive(100, TimeUnit.MILLISECONDS).ifPresent(System.out::println);

        client.disconnect();
    }
}
