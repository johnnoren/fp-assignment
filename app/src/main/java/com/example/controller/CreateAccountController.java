package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController {

	@FXML
	private Button createAccountButton;

	@FXML
	private TextField emailField;

	@FXML
	private Label errorLabel;

	@FXML
	private PasswordField passwordField;
	
	public void initialize() {
		createAccountButton.setOnAction(event -> {
			createAccount();
		});
	}

	private void createAccount() {
	}

}
