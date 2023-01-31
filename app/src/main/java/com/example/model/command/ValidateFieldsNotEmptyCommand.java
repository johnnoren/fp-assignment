package com.example.model.command;

import com.example.model.service.ControlValidator;
import javafx.scene.control.Control;
import javafx.scene.control.Label;

import java.util.LinkedHashMap;

public class ValidateFieldsNotEmptyCommand implements Command{

	private final ControlValidator validator;
	private final Label errorDisplay;

	public ValidateFieldsNotEmptyCommand(LinkedHashMap<Control, String> controls, Label errorDisplay) {
		validator = new ControlValidator(controls);
		this.errorDisplay = errorDisplay;
	}

	@Override
	public Boolean task() {
		if (validator.emptyControlExist()) {
			informUserOfRequiredFields();
			return true;
		}

		return false;
	}

	private void informUserOfRequiredFields() {
		var prefix = "The following information must be entered: ";
		var requiredFields = validator.getNamesOfEmptyControls();
		var delimiter = ", ";
		var suffix = ".";
		var fullMessage = prefix + String.join(delimiter,requiredFields) + suffix;

		errorDisplay.textProperty().set(fullMessage);
	}

}
