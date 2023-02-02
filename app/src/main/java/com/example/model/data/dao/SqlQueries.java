package com.example.model.data.dao;

public enum SqlQueries {
	CREATE_CUSTOMER("""
			call Add_Customer(?,?,?,?,?,?,?,?,?,?,?);
			"""),

	READ_ONE_CUSTOMER("""
			select
			    Customer.Id, Customer.FirstName, Customer.LastName,
			    Credentials.Id, Credentials.Email, Credentials.PasswordSalt, Credentials.PasswordHash,
			    Address.Id, Address.Street, Address.Number, Address.Other, Address.PostalCode,Address.City,
			    Country.Id, Country.Name
			from Customer
			    inner join Address on Customer.AddressId = Address.Id
			    inner join Country on Address.CountryId = Country.Id
			    inner join Credentials on Customer.CredentialsId = Credentials.Id
			where Customer.Id = ?;
			"""),

	READ_ALL_CUSTOMERS("""
			select
			    Customer.Id, Customer.FirstName, Customer.LastName,
			    Credentials.Id, Credentials.Email, Credentials.PasswordSalt, Credentials.PasswordHash,
			    Address.Id, Address.Street, Address.Number, Address.Other, Address.PostalCode, Address.City,
			    Country.Id, Country.Name
			from Customer
			    inner join Address on Customer.AddressId = Address.Id
			    inner join Country on Address.CountryId = Country.Id
			    inner join Credentials on Customer.CredentialsId = Credentials.Id;
			"""),

	UPDATE_CUSTOMER("""
			update Customer
				inner join Address on Customer.AddressId = Address.Id
				inner join Country on Address.CountryId = Country.Id
				inner join Credentials on Customer.CredentialsId = Credentials.Id
			set
				Customer.FirstName = ?,
				Customer.LastName = ?,
				Credentials.Email = ?,
				Credentials.PasswordSalt = ?,
				Credentials.PasswordHash = ?,
				Address.Street = ?,
				Address.Number = ?,
				Address.Other = ?,
				Address.PostalCode = ?,
				Address.City = ?,
				Address.CountryId = ?
			where Customer.Id = ?;
			"""),

	CREATE_COUNTRY("""
			insert into Country (Id, Name) values (?, ?);
			"""),

	READ_ONE_COUNTRY("""
			select Id, Name from Country where Id = ?
			"""),

	READ_ALL_COUNTRIES("""
			select Id, Name from Country
			"""),

	UPDATE_COUNTRY("""
			update Country set Name = ? where Id = ?
			"""),

	DELETE_COUNTRY("""
			delete from Country where Id = ?
			""");





	public final String query;

	SqlQueries(String query) {
		this.query = query;
	}
}
