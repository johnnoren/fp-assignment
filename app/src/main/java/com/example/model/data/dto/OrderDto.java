package com.example.model.data.dto;

import com.example.model.entity.Id;
import com.example.model.entity.Order;

import java.util.UUID;

public record OrderDto(UUID orderNumber, Id customerId) implements Dto<Order> {

}
