package com.example.model.data.dao;

import com.example.model.data.dao.DatabaseConnector;
import com.example.model.data.daoOLD.Dao;
import com.example.model.data.dto.CountryDTO;
import com.example.model.data.dto.Dto;
import com.example.model.entity.Country;
import com.example.model.entity.Id;
import com.example.model.property.CountryName;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country> {

	private final DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public void create(Dto<Country> countryDto) {
		return databaseConnector.execute((connection) -> {
			var statement = connection.prepareStatement(SqlQueries.CREATE_COUNTRY.query);
			statement.setString(1, (CountryDTO) countryDto.name);
			statement.executeUpdate();
		});
	}

	@Override
	public Optional<Country> read(Integer id) {
		return databaseConnector.execute((connection) -> {
			var statement = connection.prepareStatement(SqlQueries.READ_ONE_COUNTRY.query);
			statement.setInt(1,id);
			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return Optional.of(new Country(new Id(resultSet.getInt("Id")), new CountryName(resultSet.getString(
						"Name"))));
			} else {
				return Optional.empty();
			}
		});
	}

	@Override
	public List<Country> readAll() {
		return databaseConnector.execute((connection) -> {
			var statement = connection.createStatement();
			var resultSet = statement.executeQuery(SqlQueries.READ_ALL_COUNTRIES.query);
			var resultList = new ArrayList<Country>();
			while (resultSet.next()) {
				resultList.add(new Country(new Id(resultSet.getInt("Id")), new CountryName(resultSet.getString("Name")))
				);
			}
			return resultList;
		});
	}

	@Override
	public void update(Country country) {
		databaseConnector.execute((connection) -> {
			var statement = connection.prepareStatement(SqlQueries.UPDATE_COUNTRY.query);
			statement.setString(1,country.name().value());
			statement.setInt(2,country.id().value());
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

}
