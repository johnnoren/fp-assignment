package com.example.model.data.dao;

import com.example.model.data.dto.ColourDto;
import com.example.model.entity.Colour;
import com.example.model.entity.Id;
import com.example.model.property.ColourName;

public class ColourDao extends Dao<Colour, ColourDto> {

	public ColourDao() {
		super(Sql.CREATE_COLOUR, Sql.READ_ONE_COLOUR, Sql.READ_ALL_COLOURS, Sql.UPDATE_COLOUR, Sql.DELETE_COLOUR);
	}

	@Override
	protected DtoToStatementMapper<ColourDto> getMapperForCreate() {
		return (colourDto, statement) -> statement.setString(1, colourDto.name());
	}

	@Override
	protected ResultsetToEntityMapper<Colour> getMapperForRead() {
		return (resultSet -> new Colour(
				new Id(resultSet.getInt(1)),
				new ColourName(resultSet.getString(2))));
	}

	@Override
	protected EntityToStatementMapper<Colour> getMapperForUpdate() {
		return (colour, statement) -> {
			statement.setString(1,colour.colourName().value());
			statement.setInt(2,colour.id().value());
		};
	}

}
