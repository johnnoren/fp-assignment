package com.example.controller;

import com.example.model.command.ShowSceneCommand;
import com.example.model.service.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReportsController {

	@FXML
	private Button clv;

	@FXML
	private Button cpx;

	@FXML
	private Label error;

	@FXML
	private Button logout;

	@FXML
	private Button opc;

	public void initialize() {
		logout.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.LOGIN).execute());

		cpx.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORT_CPX).execute());

		opc.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORT_OPC).execute());

		clv.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORT_CLV).execute());

	}

}
