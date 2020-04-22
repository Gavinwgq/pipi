package com.gavin.pipi.mqtt;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import org.apache.commons.lang.RandomStringUtils;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangguoqiang
 * @date 2020/4/22 11:37
 */
public class MqttPub {

    public static void publish(String topic,String msg,Mqtt5BlockingClient client){
        client.publishWith().topic(topic).qos(MqttQos.AT_LEAST_ONCE).payload(msg.getBytes()).send();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("推送消息");
        String msg = "hello mqtt!";
        String topic = "test/Gavin";
        Mqtt5BlockingClient client = MqttClientFactory.getClient();
        client.connect();
        ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicInteger atomicInteger = new AtomicInteger();
        boolean exeFlag = true;
        while (exeFlag){
            if (atomicInteger.get() <= 30){
                service.execute(() -> {
                    String m = msg +"-" + RandomStringUtils.random(6,new char[]{'a','b','3','5','7','2','y'});
                    System.out.println("消息："+m);
                    publish(topic,m,client);
                    atomicInteger.getAndIncrement();
                });
            }else {
                if (((ThreadPoolExecutor)service).getActiveCount() == 0){
                    service.shutdown();
                    exeFlag=false;
                }
            }

            Thread.sleep(1000);
        }
        client.disconnect();
    }
}
