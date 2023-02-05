package com.example.controller;

import com.example.model.command.ShowSceneCommand;
import com.example.model.service.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ClvController {

	@FXML
	private Button back;

	@FXML
	private Label error;

	@FXML
	private TableView<?> table;

	public void initialize() {
		back.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORTS).execute());

	}

}