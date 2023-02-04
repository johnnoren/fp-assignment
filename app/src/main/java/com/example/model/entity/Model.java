package com.example.model.entity;

import com.example.model.property.ModelDescription;
import com.example.model.property.ModelName;

import java.util.List;

public record Model(Id id, ModelName modelName, ModelDescription description, Brand brand, List<Category> categoryList) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
