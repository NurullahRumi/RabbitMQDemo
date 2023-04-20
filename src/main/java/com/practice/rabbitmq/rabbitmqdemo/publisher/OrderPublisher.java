package com.practice.rabbitmq.rabbitmqdemo.publisher;

import com.practice.rabbitmq.rabbitmqdemo.constant.AppConstant;
import com.practice.rabbitmq.rabbitmqdemo.dto.Order;
import com.practice.rabbitmq.rabbitmqdemo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {


    private final RabbitTemplate template;

    public OrderPublisher(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order,@PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        //restaurantService
        //paymentService
        OrderStatus orderStatus = new OrderStatus(order,"PROCESS","order placed successfully "+restaurantName);
        template.convertAndSend(AppConstant.EXCHANGE,AppConstant.ROUTING_KEY,orderStatus);
        return "success";
    }
}
