package com.practice.rabbitmq.rabbitmqdemo.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor@ToString
public class OrderStatus {

    private Order order;
    private String status;
    private String message;
}
