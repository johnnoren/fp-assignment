package com.example.model.data.repository;

import com.example.model.data.dao.OrderItemDao;
import com.example.model.data.dto.OrderItemDto;
import com.example.model.entity.OrderItem;

import java.util.List;

public class OrderItemRepository {

	private final ShoeRepository shoeRepository = new ShoeRepository();
	private final OrderRepository orderRepository = new OrderRepository();
	private final OrderItemDao orderItemDao = new OrderItemDao();

	public List<OrderItem> getAll() {
		return orderItemDao.readAll().stream().map(this::createOrderItem).toList();
	}

	private OrderItem createOrderItem(OrderItemDto orderItemDto) {
		var shoe = shoeRepository.find(shoe1 -> shoe1.id().value().equals(orderItemDto.shoeId().value())).get();
		var order = orderRepository.find(order1 -> order1.id().value().equals(orderItemDto.orderId().value())).get();

		return new OrderItem(orderItemDto.id(),orderItemDto.quantity(),shoe,order);
	}

}
