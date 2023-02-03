package com.example.model.entity;

import com.example.model.property.Email;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

public record Credentials(Id id, Email email, Salt salt, HashedPassword hashedPassword) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}
}