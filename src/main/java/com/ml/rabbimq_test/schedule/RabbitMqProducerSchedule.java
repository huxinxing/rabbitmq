package com.ml.rabbimq_test.schedule;

import com.ml.rabbimq_test.producer.Producer;
import com.ml.rabbimq_test.producer.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqProducerSchedule {

    public static Integer count = 0;

    @Autowired
    Producer producer;

    @Autowired
    Publisher publisher;

    @Scheduled(fixedDelay = 100)
    public void producerTest(){
        log.info("发送消息：msg" + count++);
        producer.sendMail("test",System.currentTimeMillis()+"");
    }


//    @Scheduled(fixedDelay = 100)
//    public void publish(){
//        log.info("发送消息：msg" + count++ );
//        publisher.publish(System.currentTimeMillis()+"_" + count);
//    }
//
//
//    @Scheduled(fixedDelay = 100)
//    public void senddirect(){
//        log.info("发送消息：msg" + count++ );
//        publisher.senddirect(System.currentTimeMillis()+"_" + count,"orange");
//        publisher.senddirect(System.currentTimeMillis()+"_" + count,"black");
//        publisher.senddirect(System.currentTimeMillis()+"_" + count,"green");
//    }
//
//
//    @Scheduled(fixedDelay = 100)
//    public void sendtopic(){
//        log.info("发送消息：msg" + count++ );
//        publisher.sendtopic(System.currentTimeMillis()+"_" + count,"xxxx.orange");
//        publisher.sendtopic(System.currentTimeMillis()+"_" + count,"xxxx.xxxxx.rabbit");
//        publisher.sendtopic(System.currentTimeMillis()+"_" + count,"lazy.xxx");
//
//        publisher.sendtopic(System.currentTimeMillis()+"_sss_" + count,"xxxx.orange.sss");
//        publisher.sendtopic(System.currentTimeMillis()+"_sss_" + count,"xxxxxxxxx.rabbit");
//        publisher.sendtopic(System.currentTimeMillis()+"_sss_" + count,"lazyxxx");
//    }
}
