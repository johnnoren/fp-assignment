package com.example.model.data.dao;

import com.example.model.data.dto.OrderDto;
import com.example.model.data.dto.OrderItemDto;
import com.example.model.entity.Id;
import com.example.model.property.Quantity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderItemDao {

	protected Dao.ResultSetToEntityMapper<OrderItemDto> getMapperForRead() {
		return (resultSet -> new OrderItemDto(
				new Id(resultSet.getInt(1)),
				new Quantity(resultSet.getInt(2)),
				new Id(resultSet.getInt(3)),
				new Id(resultSet.getInt(4))
		));
	}

	public List<OrderItemDto> readAll() {
		return new DatabaseConnector().execute((connection) -> {
			var statement = connection.createStatement();
			var resultSet = statement.executeQuery(Sql.READ_ALL_ORDERITEMS.query);
			var resultList = new ArrayList<OrderItemDto>();
			while (resultSet.next()) resultList.add(getMapperForRead().map(resultSet));
			return resultList;
		});
	}

}
