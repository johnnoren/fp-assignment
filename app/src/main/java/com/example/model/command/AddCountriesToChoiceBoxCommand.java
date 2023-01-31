package com.example.model.command;

import com.example.model.data.CountryRepository;
import com.example.model.entity.address.Country;
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
		var countryNameArray = countryRepository.getAll().stream().map(Country::name).toArray(String[]::new);
		choiceBox.setItems(FXCollections.observableArrayList(countryNameArray));
		return false;
	}

}
