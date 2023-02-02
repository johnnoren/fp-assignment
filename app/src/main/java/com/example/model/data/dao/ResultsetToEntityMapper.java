package com.example.model.data.dao;

import java.sql.ResultSet;

@FunctionalInterface
public interface ResultsetToEntityMapper<T> {
	T map(ResultSet resultSet) throws Exception;
}
