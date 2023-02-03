package com.example.model.command;

import com.example.model.data.repository.CredentialsRepository;
import com.example.model.property.Email;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ValidateEmailExistsCommand implements Command {

	private final CredentialsRepository repo = new CredentialsRepository();
	private final Email email;
	private final Label errorDisplay;

	public ValidateEmailExistsCommand(TextField emailField, Label errorDisplay) {
		this.email = new Email(emailField.getText());
		this.errorDisplay = errorDisplay;
	}

	@Override
	public Boolean task() {
		if (repo.find(credentials -> credentials.email().equals(email)).isEmpty()) {
			errorDisplay.textProperty().set("No account with that email exists.");
			return true;
		}

		return false;
	}

}
