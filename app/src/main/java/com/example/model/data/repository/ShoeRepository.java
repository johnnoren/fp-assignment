package com.example.model.data.repository;

import com.example.model.data.dao.*;
import com.example.model.data.dto.*;
import com.example.model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ShoeRepository implements Repository<Shoe, ShoeDto> {

	private final Dao<Shoe, ShoeDto> shoeDao = new ShoeDao();
	private final Dao<Colour, ColourDto> colourDao = new ColourDao();
	private final Dao<StyleColour, StyleColourDto> styleColourDao = new StyleColourDao();
	private final Dao<ModelCategory, ModelCategoryDto> modelCategoryDao = new ModelCategoryDao();
	private final Dao<Category, CategoryDto> categoryDao = new CategoryDao();

	@Override
	public Optional<Shoe> find(Predicate<Shoe> condition) {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<Shoe> getAll() {
		var shoeList = shoeDao.readAll();

		shoeList.forEach(shoe -> {
			var styleId = shoe.style().id().value();
			var styleColourList =
					styleColourDao.readAll().stream().filter(styleColour -> styleColour.styleId().value().equals(styleId)).toList();
			var colourList =
					styleColourList.stream().map(styleColour -> colourDao.read(styleColour.colourId().value()).get()).toList();

			shoe.style().colourList().addAll(colourList);
				}
		);

		shoeList.forEach(shoe -> {
			var modelId = shoe.style().model().id().value();
			var modelCategoryList =
					modelCategoryDao.readAll().stream().filter(modelCategory -> modelCategory.modelId().value().equals(modelId)).toList();
			var categoryList =
					modelCategoryList.stream().map(modelCategory -> categoryDao.read(modelCategory.categoryId().value()).get()).toList();

			shoe.style().model().categoryList().addAll(categoryList);
				}
		);

		return shoeList;

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
