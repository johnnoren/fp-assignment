package com.example.model.data.dto;

import com.example.model.entity.Id;
import com.example.model.entity.OrderItem;
import com.example.model.property.Quantity;

public record OrderItemDto(Id id, Quantity quantity, Id shoeId, Id orderId) implements Dto<OrderItem> {

}
