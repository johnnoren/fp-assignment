package com.example.controller;

import com.example.model.command.AddCountriesToChoiceBoxCommand;
import com.example.model.command.ValidateEmailNotTakenCommand;
import com.example.model.command.ValidateFieldsNotEmptyCommand;
import com.example.model.javafxextension.ChoiceBoxAdapter;
import com.example.model.javafxextension.InputControl;
import com.example.model.javafxextension.PasswordFieldAdapter;
import com.example.model.javafxextension.TextFieldAdapter;
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

	private final List<InputControl> inputControls = new ArrayList<>();

	public void initialize() {
		inputControls.add(new TextFieldAdapter(email,"Email",true));
		inputControls.add(new PasswordFieldAdapter(password,"Password",true));
		inputControls.add(new TextFieldAdapter(firstName,"First modelName",true));
		inputControls.add(new TextFieldAdapter(lastName,"Last modelName",true));
		inputControls.add(new TextFieldAdapter(street,"Street",true));
		inputControls.add(new TextFieldAdapter(number,"Number",false));
		inputControls.add(new TextFieldAdapter(other,"Other",false));
		inputControls.add(new TextFieldAdapter(city,"City",true));
		inputControls.add(new TextFieldAdapter(postalCode,"Postal code",true));
		inputControls.add(new ChoiceBoxAdapter(country,"Country",true));

		createAccount.setOnAction(event -> {
			createAccount();
		});

		new AddCountriesToChoiceBoxCommand(country).execute();
	}

	private void createAccount() {
		var checkForEmptyFields = new ValidateFieldsNotEmptyCommand(inputControls,error);
		var checkForEmailNotTaken = new ValidateEmailNotTakenCommand(email,error);

		checkForEmptyFields.andThen(checkForEmailNotTaken).execute();

		// Create the account
		System.out.println("ran");

	}


}
