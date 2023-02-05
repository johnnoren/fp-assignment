package com.example.model.data.dao;

import com.example.model.data.dto.ShoeSizeDto;
import com.example.model.entity.Id;
import com.example.model.entity.ShoeSize;
import com.example.model.property.EuropeanSize;

public class ShoeSizeDao extends Dao<ShoeSize, ShoeSizeDto> {

	public ShoeSizeDao() {
		super(Sql.CREATE_SHOESIZE, Sql.READ_ONE_SHOESIZE, Sql.READ_ALL_SHOESIZES, Sql.UPDATE_SHOESIZE, Sql.DELETE_SHOESIZE);
	}

	@Override
	protected DtoToStatementMapper<ShoeSizeDto> getMapperForCreate() {
		return (shoeSizeDto, statement) -> statement.setDouble(1, shoeSizeDto.europeanSize().value());
	}

	@Override
	protected ResultSetToEntityMapper<ShoeSize> getMapperForRead() {
		return (resultSet -> new ShoeSize(
				new Id(resultSet.getInt(1)),
				new EuropeanSize(resultSet.getDouble(2))));
	}

	@Override
	protected EntityToStatementMapper<ShoeSize> getMapperForUpdate() {
		return (shoeSize, statement) -> {
			statement.setDouble(1,shoeSize.europeanSize().value());
			statement.setInt(2,shoeSize.id().value());
		};
	}

}
