package com.example.model.entity.address;

import java.util.UUID;

public record Address(UUID uuid, Street street, Number number, Other other, PostalCode postalCode, City city,
					  Country country) {

	public Address(UUID uuid, Street street, PostalCode postalCode, City city, Country country) {
		this(uuid, street, new Number(""), new Other(""), postalCode, city, country);
	}

	public Address(UUID uuid, Street street, Number number, PostalCode postalCode, City city, Country country) {
		this(uuid, street, number, new Other(""), postalCode, city, country);
	}

	public Address(UUID uuid, Street street, Other other, PostalCode postalCode, City city, Country country) {
		this(uuid, street, new Number(""), other, postalCode, city, country);
	}

}
