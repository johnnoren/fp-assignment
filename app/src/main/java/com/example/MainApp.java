package com.example;

import com.example.model.command.ShowSceneCommand;
import com.example.model.data.repository.ShoeRepository;
import com.example.model.service.SceneSwitcher.SceneId;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		new ShowSceneCommand(stage, SceneId.LOGIN).execute();
	}

	public static void main(String[] args) {
		launch(args);
	}

}