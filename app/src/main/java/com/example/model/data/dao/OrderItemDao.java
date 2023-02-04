package com.example.model.data.dao;

import com.example.model.data.dto.OrderItemDto;
import com.example.model.entity.OrderItem;

import java.sql.CallableStatement;

public class OrderItemDao extends Dao<OrderItem, OrderItemDto> {

	protected OrderItemDao() {
		super(queryForCreate, queryForReadOne, queryForReadAll, queryForUpdate, queryForDelete);
	}

	@Override
	protected DtoToStatementMapper<OrderItemDto> getMapperForCreate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ResultSetToEntityMapper<OrderItem> getMapperForRead() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected EntityToStatementMapper<OrderItem> getMapperForUpdate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

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
