package com.example.model.reports;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class OpcRow {
	SimpleStringProperty firstName;
	SimpleStringProperty lastName;
	SimpleLongProperty orders;

	public OpcRow(String firstName, String lastName, Long orders) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.orders = new SimpleLongProperty(orders);
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

	public Long getOrders() {
		return orders.get();
	}

	public SimpleLongProperty ordersProperty() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders.set(orders);
	}

}
