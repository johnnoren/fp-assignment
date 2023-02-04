package com.example.model.data.dao;

import com.example.model.data.dto.OrderDto;
import com.example.model.entity.Order;

public class OrderDao extends Dao<Order, OrderDto> {

	public OrderDao() {
		super(Sql.CREATE_ORDER, Sql.READ_ONE_ORDER, Sql.READ_ALL_ORDERS, Sql.UPDATE_ORDER, Sql.DELETE_ORDER);
	}

	@Override
	protected DtoToStatementMapper<OrderDto> getMapperForCreate() {
		return (orderDto, statement) -> {
			statement.setString(1, orderDto.orderNumber().toString());
			statement.setInt(2, orderDto.customerId().value());
		};
	}

	@Override
	protected ResultSetToEntityMapper<Order> getMapperForRead() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected EntityToStatementMapper<Order> getMapperForUpdate() {
		// TODO
		throw new UnsupportedOperationException("Not implemented");
	}

}
