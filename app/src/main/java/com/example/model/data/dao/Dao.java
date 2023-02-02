package com.example.model.data.dao;

import com.example.model.data.dto.Dto;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface Dao<T, R extends Dto<T>> {
	void create(R r);
	Optional<T> read(Integer id);
	List<T> readAll();
	void update(T t);
	void delete(T t);

	@FunctionalInterface
	interface DtoToStatementMapper<T> {
		void map(T t, CallableStatement statement) throws Exception;
	}

	@FunctionalInterface
	interface EntityToStatementMapper<T> {
		void map(T t, PreparedStatement statement) throws Exception;
	}

	@FunctionalInterface
	interface ResultsetToEntityMapper<T> {
		T map(ResultSet resultSet) throws Exception;
	}



}
