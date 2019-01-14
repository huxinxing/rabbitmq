package com.ml.rabbimq_test.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//生产者消费者模式匹配，
@Configuration
public class ProducerConsumerConfig {

    @Bean
    public Queue myQueue(){
        return new Queue("myqueue",true);
    }

}
