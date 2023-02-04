package com.example.model.data.dao;

import com.example.model.property.Price;
import com.example.model.property.StockLevel;

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
			"""),

	CREATE_SHOE("""
			call Add_Shoe(?,?,?,?,?);
			"""),

	READ_ONE_SHOE("""
			select
			    Shoe.Id, Shoe.SKU, Shoe.Price, Shoe.StockLevel,
			    ShoeSize.Id, ShoeSize.European,
			    Style.Id, Style.Name, Style.Image,
			    Model.Id, Model.Name, Model.Description,
			    Brand.Id, Brand.Name
			from Shoe
			    inner join ShoeSize on Shoe.ShoeSizeId = ShoeSize.Id
			    inner join Style on Shoe.StyleId = Style.Id
			    inner join Model on Style.ModelId = Model.Id
			    inner join Brand on Model.BrandId = Brand.Id
			where Shoe.Id = ?
			"""),

	READ_ALL_SHOES("""
			select
			    Shoe.Id, Shoe.SKU, Shoe.Price, Shoe.StockLevel,
			    ShoeSize.Id, ShoeSize.European,
			    Style.Id, Style.Name, Style.Image,
			    Model.Id, Model.Name, Model.Description,
			    Brand.Id, Brand.Name
			from Shoe
			    inner join ShoeSize on Shoe.ShoeSizeId = ShoeSize.Id
			    inner join Style on Shoe.StyleId = Style.Id
			    inner join Model on Style.ModelId = Model.Id
			    inner join Brand on Model.BrandId = Brand.Id
			"""),

	UPDATE_SHOE("""
			update Shoe set
				SKU = ?,
				Price = ?,
				StockLevel = ?,
				ShoeSizeId = ?,
				StyleId = ?
			where Id = ?
			"""),

	DELETE_SHOE("""
			delete from Colour where Id = ?
			"""),

	CREATE_COLOUR("""
			insert into Colour (Name) values (?);
			"""),

	READ_ONE_COLOUR("""
			select Id, Name from Colour where Id = ?
			"""),

	READ_ALL_COLOURS("""
			select Id, Name from Colour
			"""),

	UPDATE_COLOUR("""
			update Colour set Name = ? where Id = ?
			"""),

	DELETE_COLOUR("""
			delete from Colour where Id = ?
			"""),

	CREATE_STYLECOLOURS("""
			insert into StyleColours (StyleId, ColourId) values (?, ?);
			"""),

	READ_ONE_STYLECOLOURS("""
			select Id, StyleId, ColourId from StyleColours where Id = ?
			"""),

	READ_ALL_STYLECOLOURS("""
			select Id, StyleId, ColourId from StyleColours
			"""),

	UPDATE_STYLECOLOURS("""
			update StyleColours set StyleId = ?, ColourId = ? where Id = ?
			"""),

	DELETE_STYLECOLOURS("""
			delete from StyleColours where Id = ?
			"""),

	CREATE_MODELCATEGORY("""
			insert into ModelCategory (ModelId, CategoryId) values (?, ?);
			"""),

	READ_ONE_MODELCATEGORY("""
			select Id, ModelId, CategoryId from ModelCategory where Id = ?
			"""),

	READ_ALL_MODELCATEGORY("""
			select Id, ModelId, CategoryId from ModelCategory
			"""),

	UPDATE_MODELCATEGORY("""
			update ModelCategory set ModelId = ?, CategoryId = ? where Id = ?
			"""),

	DELETE_MODELCATEGORY("""
			delete from ModelCategory where Id = ?
			"""),

	CREATE_CATEGORY("""
			insert into Category (Id, Name) values (?, ?);
			"""),

	READ_ONE_CATEGORY("""
			select Id, Name from Category where Id = ?
			"""),

	READ_ALL_CATEGORY("""
			select Id, Name from Category
			"""),

	UPDATE_CATEGORY("""
			update Category set Name = ? where Id = ?
			"""),

	DELETE_CATEGORY("""
			delete from Category where Id = ?
			"""),

	CREATE_ORDER("""
			insert into `Order` (OrderNumber, CustomerId) values (?, ?);
			"""),

	READ_ONE_ORDER("""
			select Id, OrderDate, OrderNumber, CustomerId from Order where Id = ?;
			"""),

	READ_ALL_ORDERS("""
			select Id, OrderDate, OrderNumber, CustomerId from Order
			"""),

	UPDATE_ORDER("""
			update `Order` set Id = ?, OrderDate = ?, OrderNumber = ?, CustomerIdName = ? where Id = ?
			"""),

	DELETE_ORDER("""
			delete from `Order` where Id = ?
			""");

	public final String query;

	Sql(String query) {
		this.query = query;
	}
}
