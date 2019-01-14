package com.ml.rabbimq_test.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    RabbitTemplate amqpTemplate;


    public void publish(String  msg) {
        amqpTemplate.convertAndSend("fanout", "", msg);
    }

    public void senddirect(String  msg, String routingkey) {
        amqpTemplate.convertAndSend("direct", routingkey, msg);
    }

    public void sendtopic(String  msg, String routingkey) {
        amqpTemplate.convertAndSend("mytopic", routingkey, msg);
    }


}
