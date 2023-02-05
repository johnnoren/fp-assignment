package com.example.controller;

import com.example.model.command.ShowSceneCommand;
import com.example.model.data.repository.OrderRepository;
import com.example.model.entity.Customer;
import com.example.model.entity.Order;
import com.example.model.reports.OpcRow;
import com.example.model.service.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class OpcController {

	@FXML
	private Button back;

	@FXML
	private Label error;

	@FXML
	private TableView<OpcRow> table;

	public void initialize() {
		back.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORTS).execute());

		TableColumn<OpcRow, String> firstNameCol = new TableColumn<>("First Name");
		TableColumn<OpcRow, String> lastNameCol = new TableColumn<>("Last Name");
		TableColumn<OpcRow, Integer> totalSpentCol = new TableColumn<>("Number of orders");
		table.getColumns().clear();
		table.getColumns().addAll(firstNameCol, lastNameCol, totalSpentCol);

		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		totalSpentCol.setCellValueFactory(new PropertyValueFactory<>("orders"));

		Map<Customer, Long> customerTotalSpentMap = new OrderRepository().getAll().stream()
				.collect(Collectors.groupingBy(
							Order::customer,
							Collectors.counting()));

		var rowData = customerTotalSpentMap.keySet().stream()
				.map(customer -> new OpcRow(
						customer.firstName().value(),
						customer.lastName().value(),
						customerTotalSpentMap.get(customer)))
				.toList();

		table.getItems().addAll(rowData);

	}

}