package com.example.model.reports;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClvRow {
	SimpleStringProperty firstName;
	SimpleStringProperty lastName;
	SimpleIntegerProperty totalSpent;

	public ClvRow(String firstName, String lastName, Integer totalSpent) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.totalSpent = new SimpleIntegerProperty(totalSpent);
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

	public int getTotalSpent() {
		return totalSpent.get();
	}

	public SimpleIntegerProperty totalSpentProperty() {
		return totalSpent;
	}

	public void setTotalSpent(int totalSpent) {
		this.totalSpent.set(totalSpent);
	}

}
