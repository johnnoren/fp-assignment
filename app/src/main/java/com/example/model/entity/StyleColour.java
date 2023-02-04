package com.example.model.entity;

public record StyleColour(Id id, Id styleId, Id colourId) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
