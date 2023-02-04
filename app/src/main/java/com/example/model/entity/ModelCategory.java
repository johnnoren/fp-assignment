package com.example.model.entity;

public record ModelCategory(Id id, Id modelId, Id categoryId) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
