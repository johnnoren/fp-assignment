package com.example;

import com.example.model.service.SceneSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		new SceneSwitcher().switchTo(stage, SceneSwitcher.SceneId.LOGIN);
	}

	public static void main(String[] args) {
		launch(args);
	}

}