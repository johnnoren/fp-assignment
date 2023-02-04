package com.example.model.entity;

import com.example.model.entity.Id;
import com.example.model.property.ColourName;

public record Colour(Id id, ColourName colourName) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
