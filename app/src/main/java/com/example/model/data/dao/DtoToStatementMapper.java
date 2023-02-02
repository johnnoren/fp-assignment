package com.example.model.data.dao;

import java.sql.CallableStatement;

@FunctionalInterface
public interface DtoToStatementMapper<T> {
	void map(T t, CallableStatement statement) throws Exception;

}
