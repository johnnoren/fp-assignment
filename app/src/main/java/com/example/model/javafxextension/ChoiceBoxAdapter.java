package com.example.model.javafxextension;

import javafx.scene.control.ChoiceBox;

public class ChoiceBoxAdapter implements InputControl {

	private final ChoiceBox<String> choiceBox;
	private final String name;
	private final Boolean isMandatory;

	public ChoiceBoxAdapter(ChoiceBox<String> choiceBox, String name, Boolean isMandatory) {
		this.choiceBox = choiceBox;
		this.name = name;
		this.isMandatory = isMandatory;
	}

	@Override
	public Boolean isEmpty() {
		return choiceBox.getValue() == null;
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
		return choiceBox.getValue();
	}

}
