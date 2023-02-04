package com.example.model.data.dao;

import com.example.model.data.dto.CountryDto;
import com.example.model.entity.*;
import com.example.model.property.*;

public class CountryDao extends Dao<Country, CountryDto> {

	public CountryDao() {
		super(Sql.CREATE_COUNTRY, Sql.READ_ONE_COUNTRY, Sql.READ_ALL_COUNTRIES, Sql.UPDATE_COUNTRY, Sql.DELETE_COUNTRY);
	}

	@Override
	protected DtoToStatementMapper<CountryDto> getMapperForCreate() {
		return (countryDto, statement) -> statement.setString(1, countryDto.name());
	}

	@Override
	protected ResultSetToEntityMapper<Country> getMapperForRead() {
		return (resultSet -> new Country(
				new Id(resultSet.getInt(1)),
				new CountryName(resultSet.getString(2))));
	}

	@Override
	protected EntityToStatementMapper<Country> getMapperForUpdate() {
		return (country, statement) -> {
			statement.setString(1,country.name().value());
			statement.setInt(2,country.id().value());
		};
	}

}
