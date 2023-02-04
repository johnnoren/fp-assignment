package com.example.controller;

import com.example.model.command.AddToCartCommand;
import com.example.model.command.ShowSceneCommand;
import com.example.model.data.repository.ShoeRepository;
import com.example.model.entity.Shoe;
import com.example.model.javafxextension.ShoeListCell;
import com.example.model.service.SceneSwitcher;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.controlsfx.control.ListSelectionView;

public class ProductsController {

	@FXML
	private Label error;

	@FXML
	private Button logout;

	@FXML
	private ListSelectionView<Shoe> productSelection;


	public void initialize() {
		logout.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.LOGIN).execute());

		productSelection.getSourceItems().addAll(new ShoeRepository().getAll());

		productSelection.setCellFactory(param -> new ShoeListCell());

		productSelection.getTargetItems().addListener((ListChangeListener<Shoe>) change -> {

		});

	}

}
