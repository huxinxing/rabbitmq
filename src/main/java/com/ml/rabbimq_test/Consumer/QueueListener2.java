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


    //channel常用方法  https://www.cnblogs.com/xuwenjin/p/8970481.html



//    /**
//          * @param
//          * 1、处理成功，这种时候用basicAck确认消息；
//          * 2、可重试的处理失败，这时候用basicNack将消息重新入列；
//          * 3、不可重试的处理失败，这时候使用basicNack将消息丢弃。
//          *
//          *  basicNack(long deliveryTag, boolean multiple, boolean requeue)
//          *   deliveryTag:该消息的index
//           *  multiple：是否批量.true:将一次性拒绝所有小于deliveryTag的消息。
//            * requeue：被拒绝的是否重新入队列
//          */
//    public void onMessage(Message message, Channel channel) throws Exception {
//         
//    }byte[] body = message.getBody();
//       logger.info("接收到消息:" + new String(body));
//       JSONObject jsonObject = null;
//       try {
//           jsonObject = JSONObject.parseObject(new String(body));
//           if (消费成功) {
//               logger.info("消息消费成功");
//
//              channel.basicAck(message.getMessagePropertites().getDeliveryTag(), false);//确认消息消费成功     
//
//           } else if (可重试的失败处理) {
//
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//
//         } else {          //消费失败             
//
//              channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);             
//       } catch(JSONException e){
//           channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);//消息丢弃
//           logger.error("This message:" + jsonObject + " conversion JSON error ");
//       }
//   }


        @RabbitListener(queues = "test")
        public void displayMail (String msg, Channel channel, Message message) throws Exception {
            System.out.println("队列监听器2号收到消息" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @RabbitListener(queues = "myqueue1")
        public void fanout1 (String msg, Channel channel, Message message){
            log.info("fanout1:" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @RabbitListener(queues = "myqueue2")
        public void fanout2 (String msg, Channel channel, Message message){
            log.info("fanout2:" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @RabbitListener(queues = "direct1")
        public void direct1 (String msg, Channel channel, Message message){
            log.info("direct1:" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @RabbitListener(queues = "direct2")
        public void direct2 (String msg, Channel channel, Message message){
            log.info("direct2:" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @RabbitListener(queues = "topicqueue1")
        public void topic1 (String msg, Channel channel, Message message){
            log.info("topicqueue1:" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @RabbitListener(queues = "topicqueue2")
        public void topic2 (String msg, Channel channel, Message message){
            log.info("topicqueue2:" + msg);
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
