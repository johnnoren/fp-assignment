package com.example.model.security;

import com.example.model.security.SaltAlgorithm;

public class Salt {

	public final String value;

	public Salt() {
		this.value = new SaltAlgorithm().getNewSalt();
	}

	public Salt(String string) {
		this.value = string;
	}

}
