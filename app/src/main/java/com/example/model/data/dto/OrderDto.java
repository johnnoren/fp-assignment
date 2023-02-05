package com.example.model.data.dto;

import com.example.model.entity.Id;
import com.example.model.entity.Order;

import java.sql.Timestamp;
import java.util.UUID;

public record OrderDto(Id id, Timestamp date, UUID orderNumber, Id customerId) implements Dto<Order> {

	public OrderDto(Timestamp date, UUID orderNumber, Id customerId) {
		this(new Id(0),date,orderNumber,customerId);
	}


}
