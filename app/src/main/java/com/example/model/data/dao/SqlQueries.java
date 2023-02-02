package com.example.model.data.dao;

public enum SqlQueries {
	READ_ONE_CUSTOMER("""
			select
			    Customer.Id, Customer.FirstName, Customer.LastName,
			    Credentials.Id, Credentials.Email, Credentials.PasswordSalt, Credentials.PasswordHash,
			    Address.Id, Address.Street, Address.Number, Address.Other, Address.City, Address.PostalCode,
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
			    Address.Id, Address.Street, Address.Number, Address.Other, Address.City, Address.PostalCode,
			    Country.Id, Country.Name
			from Customer
			    inner join Address on Customer.AddressId = Address.Id
			    inner join Country on Address.CountryId = Country.Id
			    inner join Credentials on Customer.CredentialsId = Credentials.Id;
			"""),

	CREATE_CUSTOMER("""
			call Add_Customer(?,?,?,?,?,?,?,?,?,?,?);
""");

	public final String query;

	SqlQueries(String query) {
		this.query = query;
	}
}
