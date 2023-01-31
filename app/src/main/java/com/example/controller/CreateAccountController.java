package com.example.controller;

import com.example.model.command.AddCountriesToChoiceBoxCommand;
import com.example.model.command.ValidateEmailNotTakenCommand;
import com.example.model.command.ValidateFieldsNotEmptyCommand;
import com.example.model.data.CountryRepository;
import com.example.model.data.CredentialsRepository;
import com.example.model.data.Repository;
import com.example.model.entity.address.Country;
import com.example.model.entity.customer.Credentials;
import com.example.model.service.ControlValidator;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.LinkedHashMap;

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
	private final LinkedHashMap<Control,String> mandatoryControls = new LinkedHashMap<>();

	public void initialize() {
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

		new AddCountriesToChoiceBoxCommand(country).execute();
	}

	private void createAccount() {
		var checkForEmptyFields = new ValidateFieldsNotEmptyCommand(mandatoryControls,error);
		var checkForEmailNotTaken = new ValidateEmailNotTakenCommand(email,error);

		checkForEmptyFields.andThen(checkForEmailNotTaken).execute();

		// Create the account
		System.out.println("ran");

	}


}
