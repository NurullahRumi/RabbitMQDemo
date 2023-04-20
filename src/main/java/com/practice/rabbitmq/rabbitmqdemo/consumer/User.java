package com.practice.rabbitmq.rabbitmqdemo.consumer;

import com.practice.rabbitmq.rabbitmqdemo.constant.AppConstant;
import com.practice.rabbitmq.rabbitmqdemo.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
    @RabbitListener(queues = AppConstant.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from the queue: "+orderStatus);
    }
}
