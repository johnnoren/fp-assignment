package com.example.model.data.dao;

public enum Sql {
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

	DELETE_CUSTOMER("""
			delete Customer, Credentials, Address from Customer
			    inner join Credentials on Customer.CredentialsId = Credentials.Id
			    inner join Address on Customer.AddressId = Address.Id
			where
			    Customer.id = ?;
			"""),

	CREATE_COUNTRY("""
			insert into Country (Name) values (?);
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
			"""),

	CREATE_CREDENTIALS("""
			insert into Credentials (Email, PasswordSalt, PasswordHash) values (?, ?, ?);
			"""),

	READ_ONE_CREDENTIALS("""
			select Id, Email, PasswordSalt, PasswordHash from Credentials where Id = ?
			"""),

	READ_ALL_CREDENTIALS("""
			select Id, Email, PasswordSalt, PasswordHash from Credentials
			"""),

	UPDATE_CREDENTIALS("""
			update Credentials set
				Email = ?,
				PasswordSalt = ?,
				PasswordHash = ?
			where Id = ?
			"""),

	DELETE_CREDENTIALS("""
			delete from Credentials where Id = ?
			""");

	public final String query;

	Sql(String query) {
		this.query = query;
	}
}
