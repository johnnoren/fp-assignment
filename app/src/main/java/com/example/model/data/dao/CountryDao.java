package com.example.model.data.dao;

import com.example.model.entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country> {

	private DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public void create(Country country) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Optional<Country> read(Integer id) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Country> readAll() {
		return databaseConnector.execute((connection) -> {
			var statement = connection.createStatement();
			var sqlQuery = """
					select UUID, Name from Country;""";
			var resultSet = statement.executeQuery(sqlQuery);
			var resultList = new ArrayList<Country>();
			while (resultSet.next()) {
				resultList.add(new Country(resultSet.getString("Name"))
				);
			}
			return resultList;
		});
	}

	@Override
	public void update(Country country) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void delete(Country country) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

}
