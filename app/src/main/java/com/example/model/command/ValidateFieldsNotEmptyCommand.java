package com.example.model.command;

import com.example.model.javafxextension.InputControl;
import javafx.scene.control.Label;

import java.util.List;

public class ValidateFieldsNotEmptyCommand implements Command{

	private final List<InputControl> controls;
	private final Label errorDisplay;

	public ValidateFieldsNotEmptyCommand(List<InputControl> controls, Label errorDisplay) {
		this.controls = controls;
		this.errorDisplay = errorDisplay;
	}

	@Override
	public Boolean task() {
		if (anyControlIsEmpty()) {
			informUserOfRequiredFields();
			return true;
		}

		return false;
	}

	private void informUserOfRequiredFields() {
		var prefix = "The following information must be entered: ";
		var requiredFields = getEmptyFields();
		var delimiter = ", ";
		var suffix = ".";
		var fullMessage = prefix + String.join(delimiter,requiredFields) + suffix;

		errorDisplay.textProperty().set(fullMessage);
	}

	private Boolean anyControlIsEmpty() {
		return controls.stream()
				.filter(InputControl::isMandatory)
				.anyMatch(InputControl::isEmpty);
	}

	private List<String> getEmptyFields() {
		return controls.stream()
				.filter(InputControl::isMandatory)
				.filter(InputControl::isEmpty)
				.map(InputControl::getName).toList();
	}

}
