package com.example.model.security;

public class HashedPassword {
	public final String value;

	public HashedPassword(String rawPassword, Salt salt) {
		this.value = new HashAlgorithm().getHash(rawPassword, salt);
	}

	public HashedPassword(String alreadyHashedPassword) {
		this.value = alreadyHashedPassword;
	}

	public Boolean isCorrect(String rawPassword, Salt salt) {
		return new HashAlgorithm().getHash(rawPassword, salt).equals(value);
	}

}
