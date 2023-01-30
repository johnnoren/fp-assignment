package com.example;

import com.example.controller.SceneSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		new SceneSwitcher().switchTo(stage, SceneSwitcher.SceneId.LOGIN);
	}

	public static void main(String[] args) {
		launch(args);
	}

}