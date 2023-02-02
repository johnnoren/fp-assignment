package com.example.model.data.daoOLD;

import com.example.model.data.dao.DatabaseConnector;
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
	public Integer create(Country country) {
		return databaseConnector.execute((connection) -> {
			var sqlQuery = "insert into Country (Id, Name) values (?, ?)";
			var statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,country.id().value());
			statement.setString(2,country.name().value());
			statement.executeUpdate();
			return statement.getGeneratedKeys().getInt(1);
		});
	}

	@Override
	public Optional<Country> read(Integer id) {
		return databaseConnector.execute((connection) -> {
			var sqlQuery = "select Id, Name from Country where Id = ?";
			var statement = connection.prepareStatement(sqlQuery);
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
			var sqlQuery = "select Id, Name from Country";
			var resultSet = statement.executeQuery(sqlQuery);
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
			var sqlQuery = "update Country set Name = ? where Id = ?";
			var statement = connection.prepareStatement(sqlQuery);
			statement.setString(1,country.name().value());
			statement.setInt(2,country.id().value());
			statement.executeQuery();
			return null;
		});
	}

	@Override
	public void delete(Country country) {
		databaseConnector.execute((connection) -> {
			var sqlQuery = "delete from Country where Id = ?";
			var statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1,country.id().value());
			statement.executeQuery();
			return null;
		});

	}

}
