package com.example.model.security;

public class HashedPassword {
	public final String value;

	public HashedPassword(String password, Salt salt) {
		value = new HashAlgorithm().getHash(password,salt);
	}

	public HashedPassword(String alreadyHashedPassword) {
		this.value = alreadyHashedPassword;
	}

}
