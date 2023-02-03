package com.example.model.entity;

import com.example.model.property.Name;

public record Admin(Id id, Name firstName, Name lastName, Credentials credentials) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}
}
