package com.example.model.data.dao;

import com.example.model.data.dto.OrderDto;
import com.example.model.entity.Id;
import com.example.model.entity.Order;

import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderDao {

	protected Dao.DtoToStatementMapper<OrderDto> getMapperForCreate() {
		return (orderDto, statement) -> {
			statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			statement.setString(2, orderDto.orderNumber().toString());
			statement.setInt(3, orderDto.customerId().value());
		};
	}


	protected Dao.ResultSetToEntityMapper<OrderDto> getMapperForRead() {
		return (resultSet -> new OrderDto(
				new Id(resultSet.getInt(1)),
				resultSet.getTimestamp(2),
				UUID.fromString(resultSet.getString(3)),
				new Id(resultSet.getInt(4))
				));
	}


	protected Dao.EntityToStatementMapper<Order> getMapperForUpdate() {
		return (order, statement) -> {
			statement.setInt(1, order.id().value());
			statement.setTimestamp(2, order.orderDate());
			statement.setString(3, order.orderNumber().toString());
			statement.setInt(4, order.customer().id().value());
			statement.setString(5, order.orderNumber().toString());
		};
	}

	public void create(OrderDto orderDto) {
		new DatabaseConnector().execute((connection) -> {
			CallableStatement statement = connection.prepareCall(Sql.CREATE_ORDER.query);;
			getMapperForCreate().map(orderDto, statement);
			statement.execute();
			return null;
		});
	}

	public Optional<OrderDto> read(UUID orderNumber) {
		return new DatabaseConnector().execute(connection -> {
			var statement = connection.prepareStatement(Sql.READ_ONE_ORDER.query);
			statement.setString(1,orderNumber.toString());
			var resultSet = statement.executeQuery();
			return resultSet.next() ? Optional.of(getMapperForRead().map(resultSet)) : Optional.empty();
		});
	}

	public List<OrderDto> readAll() {
		return new DatabaseConnector().execute((connection) -> {
			var statement = connection.createStatement();
			var resultSet = statement.executeQuery(Sql.READ_ALL_ORDERS.query);
			var resultList = new ArrayList<OrderDto>();
			while (resultSet.next()) resultList.add(getMapperForRead().map(resultSet));
			return resultList;
		});
	}

	public void update(Order order) {
		new DatabaseConnector().execute((connection) -> {
			var statement = connection.prepareStatement(Sql.UPDATE_ORDER.query);
			getMapperForUpdate().map(order, statement);
			statement.executeQuery();
			return null;
		});
	}

	public void delete(Order order) {
		new DatabaseConnector().execute((connection) -> {
			var statement = connection.prepareStatement(Sql.DELETE_ORDER.query);
			statement.setString(1, order.orderNumber().toString());
			statement.executeQuery();
			return null;
		});
	}

}
