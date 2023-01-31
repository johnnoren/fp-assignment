package com.example.model.javafxextension;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PasswordFieldAdapter implements InputControl {
	private final PasswordField passwordField;
	private final String name;
	private final Boolean isMandatory;

	public PasswordFieldAdapter(PasswordField passwordField, String name, Boolean isMandatory) {
		this.passwordField = passwordField;
		this.name = name;
		this.isMandatory = isMandatory;
	}

	@Override
	public Boolean isEmpty() {
		return passwordField.getText().isEmpty();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Boolean isMandatory() {
		return isMandatory;
	}

	@Override
	public String getValue() {
		return passwordField.getText();
	}
}
