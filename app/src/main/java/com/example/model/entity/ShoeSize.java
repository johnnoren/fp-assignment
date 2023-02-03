package com.example.model.entity;

import com.example.model.entity.Id;
import com.example.model.property.EuropeanSize;

public record ShoeSize(Id id, EuropeanSize europeanSize) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
