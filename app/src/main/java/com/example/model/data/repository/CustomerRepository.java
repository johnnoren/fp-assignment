package com.example.model.data.repository;

import com.example.model.data.dao.CustomerDao;
import com.example.model.data.dao.Dao;
import com.example.model.data.dto.CustomerDto;
import com.example.model.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CustomerRepository implements Repository<Customer, CustomerDto> {

	private final Dao<Customer, CustomerDto> customerDao = new CustomerDao();

	@Override
	public Optional<Customer> find(Predicate<Customer> condition) {
		return customerDao.readAll().stream().filter(condition).findFirst();
	}

	@Override
	public List<Customer> getAll() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void add(CustomerDto customerDto) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void update(Customer customer) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void remove(Customer customer) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
