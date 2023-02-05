package com.example.model.data.dao;

import com.example.model.data.dto.OrderItemDto;

import java.sql.CallableStatement;

public class AdjustOrderContentsDao {

	public void AddToOrder(OrderItemDto orderItemDto) {
		new DatabaseConnector().execute((connection) -> {
			CallableStatement statement = connection.prepareCall(Sql.ADD_TO_CART.query);;
			statement.setInt(1, orderItemDto.orderId().value());
			statement.setInt(2, orderItemDto.shoeId().value());
			statement.execute();
			return null;
		});
	}

	public void RemoveFromOrder(OrderItemDto orderItemDto) {
		new DatabaseConnector().execute((connection) -> {
			CallableStatement statement = connection.prepareCall(Sql.REMOVE_FROM_CART.query);;
			statement.setInt(1, orderItemDto.orderId().value());
			statement.setInt(2, orderItemDto.shoeId().value());
			statement.execute();
			return null;
		});
	}

}
