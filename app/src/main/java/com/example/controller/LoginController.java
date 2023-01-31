package com.example.controller;

import com.example.model.command.ShowSceneCommand;
import com.example.model.service.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

	private final SceneSwitcher sceneSwitcher = new SceneSwitcher();

	public void initialize() {
		login.setOnAction(event -> {
			if (email.getText().isEmpty() || password.getText().isEmpty()) {
				error.textProperty().set("Enter email and password");
			} else {
				error.textProperty().set("");
				loginUser(email, password);
			}
		});

		signUp.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.CREATE_ACCOUNT).execute());
	}

	private void loginUser(TextField emailField, PasswordField passwordField) {
	}

}
