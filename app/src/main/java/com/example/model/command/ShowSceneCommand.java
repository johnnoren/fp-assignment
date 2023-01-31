package com.example.model.command;

import com.example.model.service.SceneSwitcher;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class ShowSceneCommand implements Command{

	private final SceneSwitcher receiver = new SceneSwitcher();
	private final Stage stage;
	private final SceneSwitcher.SceneId sceneId;

	public ShowSceneCommand(Stage stage, SceneSwitcher.SceneId sceneId) {
		this.stage = stage;
		this.sceneId = sceneId;
	}

	public ShowSceneCommand(Event event, SceneSwitcher.SceneId sceneId) {
		this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		this.sceneId = sceneId;
	}

	public ShowSceneCommand(Control control, SceneSwitcher.SceneId sceneId) {
		this.stage = (Stage) control.getScene().getWindow();
		this.sceneId = sceneId;
	}

	@Override
	public Boolean task() {
		receiver.switchTo(stage, sceneId);
		return false;
	}

}
