package com.example.model.entity;

import com.example.model.entity.Id;
import com.example.model.property.BrandName;

public record Brand(Id id, BrandName name) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
