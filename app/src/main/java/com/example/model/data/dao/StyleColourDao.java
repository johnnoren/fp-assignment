package com.example.model.data.dao;

import com.example.model.data.dto.StyleColourDto;
import com.example.model.entity.Id;
import com.example.model.entity.StyleColour;

public class StyleColourDao extends Dao<StyleColour, StyleColourDto> {

	public StyleColourDao() {
		super(Sql.CREATE_STYLECOLOURS, Sql.READ_ONE_STYLECOLOURS, Sql.READ_ALL_STYLECOLOURS, Sql.UPDATE_STYLECOLOURS,
				Sql.DELETE_STYLECOLOURS);
	}

	@Override
	protected DtoToStatementMapper<StyleColourDto> getMapperForCreate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ResultSetToEntityMapper<StyleColour> getMapperForRead() {
		return (resultSet -> new StyleColour(
				new Id(resultSet.getInt(1)),
				new Id(resultSet.getInt(2)),
				new Id(resultSet.getInt(3))));
	}

	@Override
	protected EntityToStatementMapper<StyleColour> getMapperForUpdate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
