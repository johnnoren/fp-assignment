package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private Button loginButton;

	@FXML
	private Label errorLabel;

	@FXML
	private TextField emailField;

	@FXML
	private PasswordField passwordField;

	public void initialize() {
		loginButton.setOnAction(event -> {
			if (emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
				errorLabel.textProperty().set("Enter email and password");
			} else {
				errorLabel.textProperty().set("");
				loginUser(emailField, passwordField);
			}
		});
	}

	private void loginUser(TextField emailField, PasswordField passwordField) {
	}

}
