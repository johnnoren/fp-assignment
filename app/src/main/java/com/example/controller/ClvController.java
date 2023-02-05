package com.example.controller;

import com.example.model.command.ShowSceneCommand;
import com.example.model.data.repository.OrderItemRepository;
import com.example.model.entity.Customer;
import com.example.model.entity.OrderItem;
import com.example.model.reports.ClvRow;
import com.example.model.service.SceneSwitcher;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class ClvController {

	@FXML
	private Button back;

	@FXML
	private Label error;

	@FXML
	private TableView<ClvRow> table;

	public void initialize() {
		back.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORTS).execute());

		TableColumn<ClvRow, String> firstNameCol = new TableColumn<>("First Name");
		TableColumn<ClvRow, String> lastNameCol = new TableColumn<>("Last Name");
		TableColumn<ClvRow, String> totalSpentCol = new TableColumn<>("Total spent");
		table.getColumns().clear();
		table.getColumns().addAll(firstNameCol, lastNameCol, totalSpentCol);

		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		totalSpentCol.setCellValueFactory(new PropertyValueFactory<>("totalSpent"));

		Map<Customer, Integer> customerTotalSpentMap =
				new OrderItemRepository().getAll().stream().collect(Collectors.groupingBy(orderItem -> orderItem.order().customer(),Collectors.summingInt(orderItem -> {
					var quantity = orderItem.quantity().value();
					var amount = orderItem.shoe().price().amount();
					return quantity * amount;
				})));

		var rowData = customerTotalSpentMap.keySet().stream().map(customer -> new ClvRow(customer.firstName().value()
				, customer.lastName().value(), customerTotalSpentMap.get(customer))).toList();

		table.getItems().addAll(rowData);



	}

}