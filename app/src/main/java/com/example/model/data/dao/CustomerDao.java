package com.example.model.data.dao;

import com.example.model.data.daoOLD.Dao;
import com.example.model.data.dto.CustomerDto;
import com.example.model.data.dto.Dto;
import com.example.model.entity.*;
import com.example.model.property.*;
import com.example.model.property.Number;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {

	private DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public void create(Dto<Customer> customerDto) {
		databaseConnector.execute(connection -> {
			CallableStatement statement = connection.prepareCall(SqlQueries.CREATE_CUSTOMER.query);
			customerDtoToStatement.map((CustomerDto) customerDto,statement);
			statement.execute();
			return null;
		});
	}

	@Override
	public Optional<Customer> read(Integer id) {
		return databaseConnector.execute(connection -> {
			var statement = connection.prepareStatement(SqlQueries.READ_ONE_CUSTOMER.query);
			statement.setInt(1,id);
			var resultSet = statement.executeQuery();

			return resultSet.next() ? Optional.of(resultsetToCustomer.map(resultSet)) : Optional.empty();
		});
	}

	@Override
	public List<Customer> readAll() {
		return databaseConnector.execute(connection -> {
			var statement = connection.prepareStatement(SqlQueries.READ_ALL_CUSTOMERS.query);
			var resultSet = statement.executeQuery();
			var resultList = new ArrayList<Customer>();
			while (resultSet.next()) {
				resultList.add(resultsetToCustomer.map(resultSet));
			}
			return resultList;
		});
	}

	@Override
	public void update(Customer customer) {

	}

	@Override
	public void delete(Customer customer) {

	}

	DtoToStatementMapper<CustomerDto> customerDtoToStatement = (customerDto, statement) -> {
		statement.setString(1, customerDto.firstName());
		statement.setString(2, customerDto.lastName());
		statement.setString(3, customerDto.email());
		statement.setString(4, customerDto.salt());
		statement.setString(5, customerDto.hashedPassword());
		statement.setString(6, customerDto.street());
		statement.setString(7, customerDto.number());
		statement.setString(8, customerDto.other());
		statement.setString(9, customerDto.postalCode());
		statement.setString(10, customerDto.city());
		statement.setString(11, customerDto.country());
	};

	EntityToStatementMapper<Customer> customerToUpdateStatement = (customer, statement) -> {
		statement.setInt(1,customer.id().value());
		statement.setString(2,customer.firstName().value());
		statement.setString(3, customer.lastName().value());
		statement.setInt(4, customer.credentials().id().value());
		statement.setString(5, customer.credentials().email().value());
		statement.setString(6, customer.credentials().salt().value);
		statement.setString(7, customer.credentials().hashedPassword().value);
		statement.setInt(8, customer.address().id().value());
		statement.setString(9, customer.address().street().value());
		statement.setString(10, customer.address().number().value());
		statement.setString(11, customer.address().other().value());
		statement.setString(12, customer.address().postalCode().value());
		statement.setString(13, customer.address().city().value());
		statement.setInt(14, customer.address().country().id().value());
	};

	ResultsetToEntityMapper<Customer> resultsetToCustomer = (resultSet -> new Customer(
			new Id(resultSet.getInt(1)),
			new Name(resultSet.getString(2)),
			new Name(resultSet.getString(3)),
			new Credentials(
					new Id(resultSet.getInt(4)),
					new Email(resultSet.getString(5)),
					new Salt(resultSet.getString(6)),
					new HashedPassword(resultSet.getString(7))),
			new Address(
					new Id(resultSet.getInt(8)),
					new Street(resultSet.getString(9)),
					new Number(resultSet.getString(10)),
					new Other(resultSet.getString(11)),
					new PostalCode(resultSet.getString(12)),
					new City(resultSet.getString(13)),
					new Country(
							new Id(resultSet.getInt(14)),
							new CountryName(resultSet.getString(15)))),
			new ArrayList<>()));

}