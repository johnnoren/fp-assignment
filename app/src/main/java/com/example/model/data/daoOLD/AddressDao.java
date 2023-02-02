package com.example.model.data.daoOLD;

import com.example.model.data.dao.DatabaseConnector;
import com.example.model.data.dao.ResultsetToEntityMapper;
import com.example.model.entity.Address;
import com.example.model.entity.Country;
import com.example.model.entity.Customer;
import com.example.model.entity.Id;
import com.example.model.property.*;
import com.example.model.property.Number;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDao implements Dao<Address>{

	private final DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public Integer create(Address address) {
		return databaseConnector.execute(connection -> {
			var sqlQuery = """
insert into Address (Id, Street, Number, Other, PostalCode, City, CountryId) values (?, ?, ?, ?, ?, ?, ?)""";
			var statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,address.id().value());
			statement.setString(2,address.street().value());
			statement.setString(3,address.number().value());
			statement.setString(4, address.other().value());
			statement.setString(5, address.postalCode().value());
			statement.setString(6, address.city().value());
			statement.setInt(7, address.country().id().value());
			statement.executeUpdate();
			return statement.getGeneratedKeys().getInt(1);
		});
	}

	@Override
	public Optional<Address> read(Integer id) {
		return databaseConnector.execute(connection -> {
			var sqlQuery = """
    select Address.Id, Street, Number, Other, PostalCode, City, CountryId, Country.Name as CountryName from Address
    inner join Country on CountryId = Country.Id where Address.Id = ?;
""";
			var statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1,id);
			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return Optional.of(
						new Address(
								new Id(resultSet.getInt("Id")),
								new Street(resultSet.getString("Street")),
								new Number(resultSet.getString("Number")),
								new Other(resultSet.getString("Other")),
								new PostalCode(resultSet.getString("Postal code")),
								new City(resultSet.getString("City")),
								new Country(
										new Id(resultSet.getInt("CountryId")),
										new CountryName(resultSet.getString("CountryName")))
								));
			} else {
				return Optional.empty();
			}
		});
	}

	@Override
	public List<Address> readAll() {
		return databaseConnector.execute(connection -> {
			var sqlQuery = """
    select Address.Id, Street, Number, Other, PostalCode, City, CountryId, Country.Name as CountryName from Address
    inner join Country on CountryId = Country.Id;
""";
			var statement = connection.prepareStatement(sqlQuery);
			var resultSet = statement.executeQuery();
			var resultList = new ArrayList<Address>();
			while (resultSet.next()) {
				resultList.add(
						new Address(
								new Id(resultSet.getInt("Id")),
								new Street(resultSet.getString("Street")),
								new Number(resultSet.getString("Number")),
								new Other(resultSet.getString("Other")),
								new PostalCode(resultSet.getString("Postal code")),
								new City(resultSet.getString("City")),
								new Country(
										new Id(resultSet.getInt("CountryId")),
										new CountryName(resultSet.getString("CountryName")))
						));
			}
			return resultList;
		});
	}

	@Override
	public void update(Address address) {
		databaseConnector.execute(connection -> {
			var sqlQuery = """
update Address set Id = ?, Street = ?, Number = ?, Other = ?, PostalCode = ?, City = ?, CountryId = ? where Id = ?;""";
			var statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1,address.id().value());
			statement.setString(2,address.street().value());
			statement.setString(3,address.number().value());
			statement.setString(4, address.other().value());
			statement.setString(5, address.postalCode().value());
			statement.setString(6, address.city().value());
			statement.setInt(7, address.country().id().value());
			statement.setInt(8, address.id().value());
			statement.executeQuery();
			return null;
		});
	}

	@Override
	public void delete(Address address) {

	}


	ResultsetToEntityMapper<Customer> customerFactory = (resultSet -> {
		new Customer(
				new Id(resultSet.getInt(1))
		)
	})

}
