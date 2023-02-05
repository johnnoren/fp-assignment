package com.example.model.data.repository;

import com.example.model.data.dao.OrderDao;
import com.example.model.data.dto.OrderDto;
import com.example.model.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OrderRepository {

	private final OrderDao orderDao = new OrderDao();
	private final CustomerRepository customerRepository = new CustomerRepository();

	public Optional<Order> find(Predicate<Order> condition) {
		return orderDao.readAll().stream()
				.map(this::createOrder)
				.filter(condition)
				.findFirst();
	}

	public List<Order> getAll() {
		return orderDao.readAll().stream()
				.map(this::createOrder)
				.toList();
	}

	public void add(OrderDto orderDto) {
		orderDao.create(orderDto);
	}

	public void update(Order order) {
		orderDao.update(order);
	}

	public void remove(Order order) {
		orderDao.delete(order);
	}

	private Order createOrder(OrderDto orderDto) {
		var customer =
				customerRepository.find(customer1 -> customer1.id().value().equals(orderDto.customerId().value())).get();
		return new Order(orderDto.id(),orderDto.date(),orderDto.orderNumber(), customer);
	}

}
