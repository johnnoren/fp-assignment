package com.example.model.data.dto;

import com.example.model.data.dao.OrderItemDao;
import com.example.model.entity.Id;
import com.example.model.entity.OrderItem;
import com.example.model.property.Quantity;

public record OrderItemDto(Id id, Quantity quantity, Id shoeId, Id orderId) implements Dto<OrderItem> {

	public OrderItemDto(Quantity quantity, Id shoeId, Id orderId) {
		this(new Id(0), quantity, shoeId, orderId);
	}

}
