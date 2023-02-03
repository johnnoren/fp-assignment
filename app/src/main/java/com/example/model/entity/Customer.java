package com.example.model.entity;

import com.example.model.property.Name;

import java.util.List;

public record Customer(Id id, Name firstName, Name lastName, Credentials credentials, Address address,
					   List<Order> orders) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
