package com.example.model.entity;

import com.example.model.property.Email;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

public record Credentials(Id id, Email email, Salt salt, HashedPassword hashedPassword, Boolean admin) implements Identifiable {


	public Credentials(Id id, Email email, Salt salt, HashedPassword hashedPassword) {
		this(id, email, salt, hashedPassword, false);
	}

	@Override
	public Id getId() {
		return id;
	}
}