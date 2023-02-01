package com.example.model.entity;

import com.example.model.property.Quantity;

public record OrderItem(Id id, Quantity quantity, Shoe shoe, Order order) {

}
