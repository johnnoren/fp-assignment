package com.example.model.entity.customer;

import com.example.model.entity.address.Address;
import com.example.model.entity.order.Order;

import java.util.List;
import java.util.UUID;

public record Customer(UUID uuid,Name firstName, Name lastName, Credentials credentials, Address address,
					   List<Order> orders) {

}
