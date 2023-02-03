package com.example.controller;

import com.example.model.command.ShowSceneCommand;
import com.example.model.service.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ProductsController {

	@FXML
	private ListView<?> cart;

	@FXML
	private Label error;

	@FXML
	private Button logout;

	@FXML
	private ListView<?> products;

	public void initialize() {
		logout.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.LOGIN).execute());
	}

}
