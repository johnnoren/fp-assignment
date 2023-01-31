package com.example.model.javafxextension;

import javafx.scene.control.TextField;

public class TextFieldAdapter implements InputControl {

	private final TextField textField;
	private final String name;
	private final Boolean isMandatory;

	public TextFieldAdapter(TextField textField, String name, Boolean isMandatory) {
		this.textField = textField;
		this.name = name;
		this.isMandatory = isMandatory;
	}

	@Override
	public Boolean isEmpty() {
		return textField.getText().isEmpty();
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
		return textField.getText();
	}

}
