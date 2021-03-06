package com.ml.rabbimq_test.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMail(String queue,String msg) {
        amqpTemplate.convertAndSend(queue,msg);
    }



}
