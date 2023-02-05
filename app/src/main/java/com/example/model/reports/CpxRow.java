package com.example.model.reports;

import javafx.beans.property.SimpleStringProperty;

public class CpxRow {

	SimpleStringProperty firstName;
	SimpleStringProperty lastName;
	SimpleStringProperty street;
	SimpleStringProperty number;
	SimpleStringProperty other;
	SimpleStringProperty postalCode;
	SimpleStringProperty city;
	SimpleStringProperty country;

	public CpxRow(String firstName, String lastName, String street,
			String number, String other, String postalCode,
			String city, String country) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.street = new SimpleStringProperty(street);
		this.number = new SimpleStringProperty(number);
		this.other = new SimpleStringProperty(other);
		this.postalCode = new SimpleStringProperty(postalCode);
		this.city = new SimpleStringProperty(city);
		this.country = new SimpleStringProperty(country);
	}

	public String getFirstName() {
		return firstName.get();
	}

	public SimpleStringProperty firstNameProperty() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public SimpleStringProperty lastNameProperty() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public String getStreet() {
		return street.get();
	}

	public SimpleStringProperty streetProperty() {
		return street;
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public String getNumber() {
		return number.get();
	}

	public SimpleStringProperty numberProperty() {
		return number;
	}

	public void setNumber(String number) {
		this.number.set(number);
	}

	public String getOther() {
		return other.get();
	}

	public SimpleStringProperty otherProperty() {
		return other;
	}

	public void setOther(String other) {
		this.other.set(other);
	}

	public String getPostalCode() {
		return postalCode.get();
	}

	public SimpleStringProperty postalCodeProperty() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode.set(postalCode);
	}

	public String getCity() {
		return city.get();
	}

	public SimpleStringProperty cityProperty() {
		return city;
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public String getCountry() {
		return country.get();
	}

	public SimpleStringProperty countryProperty() {
		return country;
	}

	public void setCountry(String country) {
		this.country.set(country);
	}

}