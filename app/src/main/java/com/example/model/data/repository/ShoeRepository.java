package com.example.model.data.repository;

import com.example.model.data.dao.*;
import com.example.model.data.dto.ColourDto;
import com.example.model.data.dto.CustomerDto;
import com.example.model.data.dto.ShoeDto;
import com.example.model.data.dto.StyleColourDto;
import com.example.model.entity.Colour;
import com.example.model.entity.Customer;
import com.example.model.entity.Shoe;
import com.example.model.entity.StyleColour;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ShoeRepository implements Repository<Shoe, ShoeDto> {

	private final Dao<Shoe, ShoeDto> shoeDao = new ShoeDao();
	private final Dao<Colour, ColourDto> colourDao = new ColourDao();
	private final Dao<StyleColour, StyleColourDto> styleColourDao = new StyleColourDao();

	@Override
	public Optional<Shoe> find(Predicate<Shoe> condition) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<Shoe> getAll() {
		// TODO

		// Get the incomplete shoe objects.
		var incompleShoes = shoeDao.readAll();

		// Get colours for the style and add them to the style list
		var moreCompleteShoes = new ArrayList<>(incompleShoes);
		incompleShoes.forEach(shoe -> {
			var styleId = shoe.style().id().value();
			var styleColourList =
					styleColourDao.readAll().stream().filter(styleColour -> styleColour.styleId().value().equals(styleId)).toList();
			var colourList =
					styleColourList.stream().map(styleColour -> colourDao.read(styleColour.colourId().value()).get()).toList();

			shoe.style().colourList().addAll(colourList);
				}
		);

		// Get the categories for the model

		// Add the categories to the model

	}

	@Override
	public void add(ShoeDto shoeDto) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void update(Shoe shoe) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void remove(Shoe shoe) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
