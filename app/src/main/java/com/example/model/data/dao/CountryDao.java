package com.example.model.data.dao;

import com.example.model.data.dto.CountryDto;
import com.example.model.entity.*;
import com.example.model.property.*;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country, CountryDto> {

	private final DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public void create(CountryDto countryDto) {
		databaseConnector.execute((connection) -> {
			CallableStatement statement = connection.prepareCall(SqlQueries.CREATE_COUNTRY.query);;
			countryDtoToStatement.map(countryDto, statement);
			statement.execute();
			return null;
		});
	}

	@Override
	public Optional<Country> read(Integer id) {
		return databaseConnector.execute(connection -> {
			var statement = connection.prepareStatement(SqlQueries.READ_ONE_COUNTRY.query);
			statement.setInt(1,id);
			var resultSet = statement.executeQuery();
			return resultSet.next() ? Optional.of(resultsetToCountry.map(resultSet)) : Optional.empty();
		});
	}

	@Override
	public List<Country> readAll() {
		return databaseConnector.execute((connection) -> {
			var statement = connection.createStatement();
			var resultSet = statement.executeQuery(SqlQueries.READ_ALL_COUNTRIES.query);
			var resultList = new ArrayList<Country>();
			while (resultSet.next()) resultList.add(resultsetToCountry.map(resultSet));
			return resultList;
		});
	}

	@Override
	public void update(Country country) {
		databaseConnector.execute((connection) -> {
			var statement = connection.prepareStatement(SqlQueries.UPDATE_COUNTRY.query);
			countryToUpdateStatement.map(country, statement);
			statement.executeQuery();
			return null;
		});
	}

	@Override
	public void delete(Country country) {
		databaseConnector.execute((connection) -> {
			var statement = connection.prepareStatement(SqlQueries.DELETE_COUNTRY.query);
			statement.setInt(1,country.id().value());
			statement.executeQuery();
			return null;
		});

	}

	DtoToStatementMapper<CountryDto> countryDtoToStatement = (countryDto, statement) -> {
		statement.setString(1, countryDto.name());
	};

	EntityToStatementMapper<Country> countryToUpdateStatement = (country, statement) -> {
		statement.setString(1,country.name().value());
		statement.setInt(2,country.id().value());
	};

	ResultsetToEntityMapper<Country> resultsetToCountry = (resultSet -> new Country(
			new Id(resultSet.getInt(1)),
			new CountryName(resultSet.getString(2))));
}
