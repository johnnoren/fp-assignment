package com.example.controller;

import com.example.model.command.AddSizesToChoiceBoxCommand;
import com.example.model.command.ShowSceneCommand;
import com.example.model.data.repository.OrderItemRepository;
import com.example.model.entity.Customer;
import com.example.model.reports.ClvRow;
import com.example.model.reports.CpxRow;
import com.example.model.service.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class CpxController {

	// 1. En rapport som listar alla kunder, med namn och adress, som har handlat varor i en viss storlek,
	// av en viss färg eller av ett visst märke.

	@FXML
	private Button back;

	@FXML
	private Label error;

	@FXML
	private TableView<CpxRow> table;

	@FXML
	private ChoiceBox<String> size;


	public void initialize() {
		back.setOnAction(event -> new ShowSceneCommand(event, SceneSwitcher.SceneId.REPORTS).execute());

		TableColumn<CpxRow, String> firstNameCol = new TableColumn<>("First Name");
		TableColumn<CpxRow, String> lastNameCol = new TableColumn<>("Last Name");
		TableColumn<CpxRow, String> streetCol = new TableColumn<>("Street");
		TableColumn<CpxRow, String> numberCol = new TableColumn<>("Number");
		TableColumn<CpxRow, String> otherCol = new TableColumn<>("Other");
		TableColumn<CpxRow, String> postalCodeCol = new TableColumn<>("Postal Code");
		TableColumn<CpxRow, String> cityCol = new TableColumn<>("City");
		TableColumn<CpxRow, String> countryCol = new TableColumn<>("Country");

		table.getColumns().clear();
		table.getColumns().addAll(firstNameCol, lastNameCol, streetCol, numberCol, otherCol, postalCodeCol, cityCol,
				countryCol);

		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
		numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
		otherCol.setCellValueFactory(new PropertyValueFactory<>("other"));
		postalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
		cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
		countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

		size.setOnAction(event -> updateTableWithCustomers(Double.parseDouble(size.getValue())));

		new AddSizesToChoiceBoxCommand(size).execute();

	}

	private void updateTableWithCustomers(Double size) {
		table.getItems().clear();

		var rowData = new OrderItemRepository().getAll().stream()
				.filter(orderItem -> orderItem.shoe().size().europeanSize().value().equals(size))
				.map(orderItem -> orderItem.order().customer())
				.map(customer -> new CpxRow(customer.firstName().value(), customer.lastName().value(),
						customer.address().street().value(),customer.address().number().value(),
						customer.address().other().value(),customer.address().postalCode().value(),
						customer.address().city().value(),customer.address().country().name().value()))
				.toList();

		table.getItems().addAll(rowData);
	}



}
