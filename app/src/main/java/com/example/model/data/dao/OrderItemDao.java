package com.example.model.data.dao;

import com.example.model.data.dto.OrderItemDto;
import com.example.model.entity.OrderItem;

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

}
