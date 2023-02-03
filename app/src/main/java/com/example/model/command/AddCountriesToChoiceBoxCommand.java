package com.example.model.command;

import com.example.model.data.repository.CountryRepository;
import com.example.model.entity.Country;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class AddCountriesToChoiceBoxCommand implements Command {

	private final CountryRepository countryRepository = new CountryRepository();
	private final ChoiceBox<String> choiceBox;

	public AddCountriesToChoiceBoxCommand(ChoiceBox<String> choiceBox) {
		this.choiceBox = choiceBox;
	}

	@Override
	public Boolean task() {
		var countryNameArray =
				countryRepository.getAll().stream().map(country -> country.name().value()).toArray(String[]::new);
		choiceBox.setItems(FXCollections.observableArrayList(countryNameArray));
		return false;
	}

}
