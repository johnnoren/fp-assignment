package com.example.model.entity;

import com.example.model.entity.Id;
import com.example.model.property.BrandName;
import com.example.model.property.CategoryName;

public record Category(Id id, CategoryName categoryName) implements Identifiable{

	@Override
	public Id getId() {
		return id;
	}

}
