package com.ml.rabbimq_test.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//direct直连模式的交换机配置,包括一个direct交换机，两个队列，三根网线binding
@Configuration
public class DirectExchangeConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct",true,false);
    }

    @Bean
    public Queue directQueue1(){
        return new Queue("direct1",true);
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("direct2",true);
    }

    @Bean
    public Binding bindingOrange(){
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("orange");
    }

    @Bean
    public Binding bindingBlack(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("black");
    }

    @Bean
    public Binding bindingGreen(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("green");
    }
}
