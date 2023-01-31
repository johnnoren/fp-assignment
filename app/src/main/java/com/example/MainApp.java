package com.example;

import com.example.model.command.ShowSceneCommand;
import com.example.model.service.SceneSwitcher.SceneId;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		new ShowSceneCommand(stage, SceneId.LOGIN).execute();
	}

	public static void main(String[] args) {
		launch(args);
	}

}