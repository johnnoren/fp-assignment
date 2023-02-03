package com.example.model.command;

import com.example.model.data.repository.CredentialsRepository;
import com.example.model.property.Email;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ValidatePasswordIsCorrectCommand implements Command {
	private final CredentialsRepository repo = new CredentialsRepository();
	private final Email email;
	private final String rawPassword;
	private final Label errorDisplay;

	public ValidatePasswordIsCorrectCommand(TextField emailField, PasswordField passwordField, Label errorDisplay) {
		this.email = new Email(emailField.getText());
		this.rawPassword = passwordField.getText();
		this.errorDisplay = errorDisplay;
	}

	@Override
	public Boolean task() {
		var storedCredentials = repo.find(credentials -> credentials.email().equals(email)).get();
		var salt = storedCredentials.salt();
		var hashedPassword = storedCredentials.hashedPassword();

		if (hashedPassword.isCorrect(rawPassword,salt)) {
			return false;
		}

		errorDisplay.textProperty().set("Incorrect password.");
		return true;
	}

}
