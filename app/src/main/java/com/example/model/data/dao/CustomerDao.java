package com.example.model.data.dao;

import com.example.model.data.dto.CustomerDto;
import com.example.model.entity.*;
import com.example.model.property.*;
import com.example.model.property.Number;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

import java.util.ArrayList;

public class CustomerDao extends Dao<Customer, CustomerDto> {

	public CustomerDao() {
		super(Sql.CREATE_CUSTOMER, Sql.READ_ONE_CUSTOMER, Sql.READ_ALL_CUSTOMERS,
				Sql.UPDATE_CUSTOMER, Sql.DELETE_CUSTOMER);
	}

	@Override
	protected DtoToStatementMapper<CustomerDto> getMapperForCreate() {
		return (customerDto, statement) -> {
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
	}

	@Override
	protected ResultsetToEntityMapper<Customer> getMapperForRead() {
		return (resultSet -> new Customer(
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

	@Override
	protected EntityToStatementMapper<Customer> getMapperForUpdate() {
		return (customer, statement) -> {
			statement.setString(1,customer.firstName().value());
			statement.setString(2, customer.lastName().value());
			statement.setString(3, customer.credentials().email().value());
			statement.setString(4, customer.credentials().salt().value);
			statement.setString(5, customer.credentials().hashedPassword().value);
			statement.setString(6, customer.address().street().value());
			statement.setString(7, customer.address().number().value());
			statement.setString(8, customer.address().other().value());
			statement.setString(9, customer.address().postalCode().value());
			statement.setString(10, customer.address().city().value());
			statement.setInt(11, customer.address().country().id().value());
			statement.setInt(12,customer.id().value());
		};
	}

}