package com.example.controller;

import com.example.model.data.CountryRepository;
import com.example.model.data.Repository;
import com.example.model.entity.Country;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountController {

	@FXML
	private TextField city;

	@FXML
	private ChoiceBox<String> country;

	@FXML
	private Button createAccount;

	@FXML
	private TextField email;

	@FXML
	private Label error;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField number;

	@FXML
	private TextField other;

	@FXML
	private PasswordField password;

	@FXML
	private TextField postalCode;

	@FXML
	private TextField street;

	private final Repository<Country> countryRepository = new CountryRepository();
	
	public void initialize() {
		createAccount.setOnAction(event -> {
			createAccount();
		});

		addCountriesToChoicebox();
	}

	private void addCountriesToChoicebox() {
		var countryNameArray = countryRepository.getAll().stream().map(country -> country.name()).toArray(String[]::new);
		country.setItems(FXCollections.observableArrayList(countryNameArray));
	}

	private void createAccount() {

		// check that all fields are filled in
		var fieldsNotFilledList = getMandatoryFieldsNotFilled();
		if (!fieldsNotFilledList.isEmpty()){
			var errorMessage = "The following information must be entered: " + String.join(", ",fieldsNotFilledList);
			error.textProperty().set(errorMessage);
			return;
		}

		// check if there is an account with that email already

	}

	private List<String> getMandatoryFieldsNotFilled() {
		var fieldsNotFilledList = new ArrayList<String>();
		if (email.getText().isEmpty()) fieldsNotFilledList.add("Email");
		if (password.getText().isEmpty()) fieldsNotFilledList.add("Password");
		if (firstName.getText().isEmpty()) fieldsNotFilledList.add("First name");
		if (lastName.getText().isEmpty()) fieldsNotFilledList.add("Last name");
		if (street.getText().isEmpty()) fieldsNotFilledList.add("Street");
		if (city.getText().isEmpty()) fieldsNotFilledList.add("City");
		if (postalCode.getText().isEmpty()) fieldsNotFilledList.add("Postal code");
		if (country.getValue() == null) fieldsNotFilledList.add("Country");
		return fieldsNotFilledList;

	}

}
