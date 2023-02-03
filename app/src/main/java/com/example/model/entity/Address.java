package com.example.model.entity;

import com.example.model.property.*;
import com.example.model.property.Number;

public record Address(Id id, Street street, Number number, Other other, PostalCode postalCode, City city,
					  Country country) implements Identifiable {

	public Address(Id id, Street street, PostalCode postalCode, City city, Country country) {
		this(id, street, new Number(""), new Other(""), postalCode, city, country);
	}

	public Address(Id id, Street street, Number number, PostalCode postalCode, City city, Country country) {
		this(id, street, number, new Other(""), postalCode, city, country);
	}

	public Address(Id id, Street street, Other other, PostalCode postalCode, City city, Country country) {
		this(id, street, new Number(""), other, postalCode, city, country);
	}

	@Override
	public Id getId() {
		return id;
	}

}
