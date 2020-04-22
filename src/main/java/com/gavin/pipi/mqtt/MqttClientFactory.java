package com.gavin.pipi.mqtt;

import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.mqtt3.Mqtt3Client;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

import java.util.UUID;

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


    public static Mqtt5BlockingClient getClient(){
       return Mqtt5Client.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("182.61.11.118")
                .serverPort(1883)
                .buildBlocking();
    }
}
