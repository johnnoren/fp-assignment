package com.example.model.service;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Map;

public class ControlValidator {
	private final Map<Control, String> inputControls;

	public ControlValidator(Map<Control, String> inputControlToNameMap) {
		this.inputControls = inputControlToNameMap;
	}

	public List<String> getNamesOfEmptyControls() {
		return inputControls.keySet().stream()
				.map(control -> controlIsEmpty(control) ? inputControls.get(control) : "")
				.filter(string -> !string.isEmpty())
				.toList();

	}

	public Boolean emptyControlExist() {
		return !getNamesOfEmptyControls().isEmpty();
	}

	private Boolean controlIsEmpty(Control control) {
		var type = control.getClass().getName();
		return switch (type) {
			case "javafx.scene.control.TextField", "javafx.scene.control.PasswordField" -> {
				var textField = (TextField) control;
				yield textField.getText().isEmpty();
			}
			case "javafx.scene.control.ChoiceBox" -> {
				var choiceBox = (ChoiceBox) control;
				yield choiceBox.getValue() == null;
			}
			default -> true;
		};
	}

}
