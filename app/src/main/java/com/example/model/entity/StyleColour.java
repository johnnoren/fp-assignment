package com.example.model.entity;

public record StyleColour(Id id, Style style, Colour colour) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
