package com.example.model.entity;

import com.example.model.entity.Id;
import com.example.model.property.CountryName;

public record Country(Id id, CountryName name) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
