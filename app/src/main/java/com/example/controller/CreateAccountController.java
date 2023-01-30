package com.example.controller;

import com.example.model.data.CountryRepository;
import com.example.model.data.CredentialsRepository;
import com.example.model.data.Repository;
import com.example.model.entity.Country;
import com.example.model.entity.Credentials;
import com.example.model.service.ControlValidator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

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
	private final Repository<Credentials> credentialsRepository = new CredentialsRepository();
	private ControlValidator controlValidator;

	public void initialize() {
		var mandatoryControls = new LinkedHashMap<Control, String>();
		mandatoryControls.put(email,"Email");
		mandatoryControls.put(password,"Password");
		mandatoryControls.put(firstName,"First name");
		mandatoryControls.put(lastName, "Last name");
		mandatoryControls.put(street, "Street");
		mandatoryControls.put(city, "City");
		mandatoryControls.put(postalCode, "Postal code");
		mandatoryControls.put(country, "Country");

		controlValidator = new ControlValidator(mandatoryControls);

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
		if (controlValidator.emptyControlExist()) {
			informUserOfRequiredFields();
			return;
		}

		// Check if there is an account with that email already
		if (credentialsRepository.find(credentials -> credentials.email().equals(email.getText())).isPresent()) {
			error.textProperty().set("An account with that email already exists.");
			return;
		}

		// Create the account
		System.out.println("ran");

	}

	private void informUserOfRequiredFields() {
		var errorMessage = "The following information must be entered: " + String.join(", ", controlValidator.getNamesOfEmptyControls());
		error.textProperty().set(errorMessage);
	}

}
