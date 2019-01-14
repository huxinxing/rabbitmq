package com.ml.rabbimq_test.Consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class QueueListener2 {

    @RabbitListener(queues = "test")
    public void displayMail(String msg, Channel channel, Message message) throws Exception {
        System.out.println("队列监听器2号收到消息" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "myqueue1")
    public void fanout1(String msg, Channel channel, Message message){
        log.info("fanout1:" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "myqueue2")
    public void fanout2(String msg, Channel channel, Message message){
        log.info("fanout2:" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RabbitListener(queues = "direct1")
    public void direct1(String msg, Channel channel, Message message){
        log.info("direct1:" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "direct2")
    public void direct2(String msg, Channel channel, Message message){
        log.info("direct2:" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RabbitListener(queues = "topicqueue1")
    public void topic1(String msg, Channel channel, Message message){
        log.info("topicqueue1:" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "topicqueue2")
    public void topic2(String msg, Channel channel, Message message){
        log.info("topicqueue2:" + msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
