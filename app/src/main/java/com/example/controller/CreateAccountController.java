package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController {

	@FXML
	private Button createAccount;

	@FXML
	private TextField email;

	@FXML
	private Label error;

	@FXML
	private PasswordField password;
	
	public void initialize() {
		createAccount.setOnAction(event -> {
			createAccount();
		});
	}

	private void createAccount() {
	}

}
