package com.example.model.command;

import com.example.model.data.dto.OrderDto;
import com.example.model.data.repository.CustomerRepository;
import com.example.model.data.repository.OrderRepository;
import com.example.model.service.Session;

import java.util.UUID;

public class CreateNewOrderCommand implements Command {

	private final CustomerRepository customerRepository = new CustomerRepository();
	private final OrderRepository orderRepository = new OrderRepository();

	@Override
	public Boolean task() {
		var customerCredentialsId = Session.getSession().getCurrentUserId();
		var customerOptional =
				customerRepository.find(customer -> customer.credentials().id().value().equals(customerCredentialsId.value()));
		var customerId = customerOptional.get().id();
		var orderNumber = UUID.randomUUID();

		orderRepository.add(new OrderDto(orderNumber, customerId));

		Session.getSession().setCurrentCustomerId(customerId);
		Session.getSession().setCurrentOrderNumber(orderNumber);

		return false;
	}

}
