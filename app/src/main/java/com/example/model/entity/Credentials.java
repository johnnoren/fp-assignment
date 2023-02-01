package com.example.model.entity;

import com.example.model.property.Email;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

public record Credentials(Id id, Email email, Salt salt, HashedPassword hashedPassword) {

	public static Credentials generate(Email email, String password) {
		var salt = new Salt();
		var hashedPassword = new HashedPassword(password,salt);
		return new Credentials(email,salt,hashedPassword); // TODO id
	}
}