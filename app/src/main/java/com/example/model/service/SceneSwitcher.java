package com.example.model.service;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

	public enum SceneId {
		LOGIN("/com/example/view/login.fxml", "Skoo - login", 700, 400),
		CREATE_ACCOUNT("/com/example/view/createAccount.fxml", "Skoo - sign up", 700, 400),
		PRODUCTS("/com/example/view/products.fxml", "Skoo - products", 700, 400),
		REPORTS("/com/example/view/reports.fxml", "Skoo - reports", 700, 400),
		REPORT_CLV("/com/example/view/clv.fxml", "Skoo - Customer lifetime value", 700, 400),
		REPORT_CPX("/com/example/view/cpx.fxml", "Skoo - Customers who purchased x", 700, 400),
		REPORT_OPC("/com/example/view/opc.fxml", "Skoo - Number of orders per customer", 700, 400);

		public final String resourceName;
		public final String title;
		public final int width;
		public final int height;

		SceneId(String resourceName, String title, int width, int height) {
			this.resourceName = resourceName;
			this.title = title;
			this.width = width;
			this.height = height;
		}
	}

	public void switchTo(Stage stage, SceneId sceneId) {
		performSceneSwitch(stage,getParent(sceneId), sceneId.title, sceneId.width, sceneId.height);
	}

	public void switchTo(Event event, SceneId sceneId) {
		performSceneSwitch(getStageByEvent(event), getParent(sceneId), sceneId.title, sceneId.width, sceneId.height);
	}

	private Stage getStageByEvent(Event event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}

	private Parent getParent(SceneId sceneId) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource(sceneId.resourceName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return parent;
	}

	private void performSceneSwitch(Stage stage, Parent parent, String stageTitle, int width, int height) {
		Scene scene = new Scene(parent,width,height);
		scene.getStylesheets().add(getClass().getResource("/com/example/styles.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle(stageTitle);
		stage.show();
	}
}
