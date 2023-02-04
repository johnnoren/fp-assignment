package com.example.model.data.repository;

import com.example.model.data.dao.OrderDao;
import com.example.model.data.dto.OrderDto;
import com.example.model.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OrderRepository implements Repository<Order, OrderDto> {

	private final OrderDao orderDao = new OrderDao();

	@Override
	public Optional<Order> find(Predicate<Order> condition) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<Order> getAll() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void add(OrderDto orderDto) {
		orderDao.create(orderDto);
	}

	@Override
	public void update(Order order) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void remove(Order order) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
