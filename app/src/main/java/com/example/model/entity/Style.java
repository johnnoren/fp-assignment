package com.example.model.entity;

import com.example.model.property.ProductImage;
import com.example.model.property.StyleName;

import java.util.List;

public record Style(Id id, StyleName styleName, ProductImage productImage, Model model, List<Colour> colourList) implements Identifiable {

	@Override
	public Id getId() {
		return id;
	}

}
