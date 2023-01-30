package com.example.controller;

import com.example.model.service.SceneSwitcher;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

		signUp.setOnAction(event -> {
			sceneSwitcher.switchTo(event, SceneSwitcher.SceneId.CREATE_ACCOUNT);
		});
	}

	private void loginUser(TextField emailField, PasswordField passwordField) {
	}

	private void changeScene(Event event, Scene scene) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
	}

}
