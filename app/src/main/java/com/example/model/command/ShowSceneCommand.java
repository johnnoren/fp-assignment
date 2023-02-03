package com.example.model.command;

import com.example.model.service.SceneSwitcher;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import static com.example.model.service.SceneSwitcher.*;

public class ShowSceneCommand implements Command{

	private final SceneSwitcher receiver = new SceneSwitcher();
	private final Stage stage;
	private final SceneId sceneId;

	public ShowSceneCommand(Stage stage, SceneId sceneId) {
		this.stage = stage;
		this.sceneId = sceneId;
	}

	public ShowSceneCommand(Event event, SceneId sceneId) {
		this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		this.sceneId = sceneId;
	}

	public ShowSceneCommand(Control control, SceneId sceneId) {
		this.stage = (Stage) control.getScene().getWindow();
		this.sceneId = sceneId;
	}

	@Override
	public Boolean task() {
		receiver.switchTo(stage, sceneId);
		return false;
	}

}
