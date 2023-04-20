package com.practice.rabbitmq.rabbitmqdemo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private String OrderId;
    private String name;
    private int qty;
    private double price;
}
