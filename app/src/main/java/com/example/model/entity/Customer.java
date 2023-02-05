package com.example.model.entity;

import com.example.model.property.Name;

import java.util.List;

public record Customer(Id id, Name firstName, Name lastName, Credentials credentials, Address address,
					   List<Order> orders) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Customer c)) {
			return false;
		}
		return c.getId().value().equals(this.getId().value());
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + this.id.value();
		return hash;
	}

}
