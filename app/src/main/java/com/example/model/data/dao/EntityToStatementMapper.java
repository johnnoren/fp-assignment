package com.example.model.data.dao;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface EntityToStatementMapper<T> {
	void map(T t, PreparedStatement statement) throws Exception;
}