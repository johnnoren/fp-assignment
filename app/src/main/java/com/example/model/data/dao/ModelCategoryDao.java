package com.example.model.data.dao;

import com.example.model.data.dto.ModelCategoryDto;
import com.example.model.entity.Id;
import com.example.model.entity.ModelCategory;

public class ModelCategoryDao extends Dao<ModelCategory, ModelCategoryDto> {

	public ModelCategoryDao() {
		super(Sql.CREATE_MODELCATEGORY, Sql.READ_ONE_MODELCATEGORY, Sql.READ_ALL_MODELCATEGORY,
				Sql.UPDATE_MODELCATEGORY, Sql.DELETE_MODELCATEGORY);
	}

	@Override
	protected DtoToStatementMapper<ModelCategoryDto> getMapperForCreate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ResultSetToEntityMapper<ModelCategory> getMapperForRead() {
		return (resultSet -> new ModelCategory(
				new Id(resultSet.getInt(1)),
				new Id(resultSet.getInt(2)),
				new Id(resultSet.getInt(3))));
	}

	@Override
	protected EntityToStatementMapper<ModelCategory> getMapperForUpdate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
