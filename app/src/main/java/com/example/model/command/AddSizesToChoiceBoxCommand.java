package com.example.model.command;

import com.example.model.data.repository.ShoeSizeRepository;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class AddSizesToChoiceBoxCommand implements Command {

	private final ShoeSizeRepository shoeSizeRepository = new ShoeSizeRepository();
	private final ChoiceBox<String> choiceBox;

	public AddSizesToChoiceBoxCommand(ChoiceBox<String> choiceBox) {
		this.choiceBox = choiceBox;
	}

	@Override
	public Boolean task() {
		var shoeSizeArray =
				shoeSizeRepository.getAll().stream().map(shoeSize -> shoeSize.europeanSize().value()).map(String::valueOf
		).toArray(String[]::new);
		choiceBox.setItems(FXCollections.observableArrayList(shoeSizeArray));
		return false;
	}

}
