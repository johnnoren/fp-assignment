package com.example.model.command;

import com.example.model.data.CredentialsRepository;
import com.example.model.entity.customer.Email;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ValidateEmailNotTakenCommand implements Command {

	private final CredentialsRepository repo = new CredentialsRepository();
	private final Email email;
	private final Label errorDisplay;

	public ValidateEmailNotTakenCommand(TextField emailField, Label errorDisplay) {
		this.email = new Email(emailField.getText());
		this.errorDisplay = errorDisplay;
	}

	@Override
	public Boolean task() {
		System.out.println(email);
		System.out.println(repo.find(credentials -> credentials.email().equals(email)).isPresent());
		if (repo.find(credentials -> credentials.email().equals(email)).isPresent()) {
			errorDisplay.textProperty().set("An account with that email already exists.");
			return true;
		}

	return false;
	}

}
