package com.example.model.security;

import java.security.SecureRandom;
import java.util.Base64;

public class SaltAlgorithm {
	public String getNewSalt() throws Exception {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		// NIST recommends minimum 4 bytes. We use 8.
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}

}
