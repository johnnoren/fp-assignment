package com.example.model.entity.order;

import com.example.model.entity.shoe.Shoe;

import java.util.UUID;

public record OrderItem(UUID uuid, Quantity quantity, Shoe shoe) {

}
