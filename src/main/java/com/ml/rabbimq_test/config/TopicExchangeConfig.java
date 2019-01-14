package com.ml.rabbimq_test.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("mytopic");
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue("topicqueue1",true);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topicqueue2",true);
    }

    @Bean
    public Binding bindingTopic1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.orange.*");
    }

    @Bean
    public Binding bindingTolpic2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("*.*.rabbit");
    }

    @Bean
    public Binding bingTppic3(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("lazy.#");
    }


}
