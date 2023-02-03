package com.example.controller;

import com.example.model.command.*;
import com.example.model.javafxextension.InputControl;
import com.example.model.javafxextension.PasswordFieldAdapter;
import com.example.model.javafxextension.TextFieldAdapter;
import com.example.model.property.Email;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import static com.example.model.service.SceneSwitcher.*;

public class LoginController {

	@FXML
	private Button login;

	@FXML
	private Button signUp;

	@FXML
	private Label error;

	@FXML
	private TextField email;

	@FXML
	private PasswordField password;

	private final List<InputControl> inputControls = new ArrayList<>();

	public void initialize() {
		inputControls.add(new TextFieldAdapter(email,"Email",true));
		inputControls.add(new PasswordFieldAdapter(password,"Password",true));

		login.setOnAction(this::validateAndLogin);

		signUp.setOnAction(event -> new ShowSceneCommand(event, SceneId.CREATE_ACCOUNT).execute());
	}

	private void validateAndLogin(Event event) {
		var checkForEmptyFields = new ValidateFieldsNotEmptyCommand(inputControls,error);
		var checkThatAccountExists = new ValidateEmailExistsCommand(email,error);
		var checkThatPasswordIsCorrect = new ValidatePasswordIsCorrectCommand(email,password,error);
		var loginUser = new LoginUserCommand(new Email(email.getText()));
		var showOrderingScreen = new ShowSceneCommand(event,SceneId.PRODUCTS);

		checkForEmptyFields
				.andThen(checkThatAccountExists)
				.andThen(checkThatPasswordIsCorrect)
				.andThen(loginUser)
				.andThen(showOrderingScreen).execute();

	}

}
