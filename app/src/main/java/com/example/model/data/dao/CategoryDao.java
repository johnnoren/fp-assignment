package com.example.model.data.dao;

import com.example.model.data.dto.CategoryDto;
import com.example.model.entity.Category;
import com.example.model.entity.Id;
import com.example.model.property.CategoryName;

public class CategoryDao extends Dao<Category, CategoryDto> {

	public CategoryDao() {
		super(Sql.CREATE_CATEGORY, Sql.READ_ONE_CATEGORY, Sql.READ_ALL_CATEGORY, Sql.UPDATE_CATEGORY, Sql.DELETE_CATEGORY);
	}

	@Override
	protected DtoToStatementMapper<CategoryDto> getMapperForCreate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ResultSetToEntityMapper<Category> getMapperForRead() {
		return (resultSet -> new Category(
				new Id(resultSet.getInt(1)),
				new CategoryName(resultSet.getString(2))));
	}

	@Override
	protected EntityToStatementMapper<Category> getMapperForUpdate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
