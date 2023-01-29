package com.example.model.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class HashAlgorithm {
	public String getHash(String stringToHash, String salt) {
		String algorithm = "PBKDF2WithHmacSHA1";
		int derivedKeyLength = 160; // for SHA1
		int iterations = 20000; // NIST specifies 10000

		byte[] saltBytes = Base64.getDecoder().decode(salt);
		KeySpec spec = new PBEKeySpec(stringToHash.toCharArray(), saltBytes, iterations, derivedKeyLength);
		SecretKeyFactory secretKeyFactory;
		byte[] encodedBytes;
		try {
			secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
			encodedBytes = secretKeyFactory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}

		return Base64.getEncoder().encodeToString(encodedBytes);
	}
}
