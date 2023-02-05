package com.example.model.data.dao;

import com.example.model.data.dto.OrderItemDto;

import java.sql.CallableStatement;
import java.sql.Types;

public class AdjustOrderContentsDao {

	public boolean AddToOrder(OrderItemDto orderItemDto) {
		return new DatabaseConnector().execute((connection) -> {
			CallableStatement statement = connection.prepareCall(Sql.ADD_TO_CART.query);;
			statement.setInt(1, orderItemDto.orderId().value());
			statement.setInt(2, orderItemDto.shoeId().value());
			statement.registerOutParameter(3, Types.INTEGER);
			statement.execute();
			return statement.getInt(3) == 0;
		});
	}

	public boolean RemoveFromOrder(OrderItemDto orderItemDto) {
		return new DatabaseConnector().execute((connection) -> {
			CallableStatement statement = connection.prepareCall(Sql.REMOVE_FROM_CART.query);;
			statement.setInt(1, orderItemDto.orderId().value());
			statement.setInt(2, orderItemDto.shoeId().value());
			statement.registerOutParameter(3, Types.INTEGER);
			statement.execute();
			return statement.getInt(3) == 0;
		});
	}

}
