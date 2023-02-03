package com.example.model.data.dao;

import com.example.model.data.dto.Dto;
import com.example.model.entity.Identifiable;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Dao<T extends Identifiable, R extends Dto<T>> {

	private final Sql queryForCreate;
	private final Sql queryForReadOne;
	private final Sql queryForReadAll;
	private final Sql queryForUpdate;
	private final Sql queryForDelete;

	protected Dao(Sql queryForCreate, Sql queryForReadOne, Sql queryForReadAll, Sql queryForUpdate, Sql queryForDelete) {
		this.queryForCreate = queryForCreate;
		this.queryForReadOne = queryForReadOne;
		this.queryForReadAll = queryForReadAll;
		this.queryForUpdate = queryForUpdate;
		this.queryForDelete = queryForDelete;
	}

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

	protected abstract DtoToStatementMapper<R> getMapperForCreate();
	protected abstract ResultsetToEntityMapper<T> getMapperForRead();
	protected abstract EntityToStatementMapper<T> getMapperForUpdate();

	public void create(R r) {
		new DatabaseConnector().execute((connection) -> {
			CallableStatement statement = connection.prepareCall(queryForCreate.query);;
			getMapperForCreate().map(r, statement);
			statement.execute();
			return null;
		});
	}

	public Optional<T> read(Integer id) {
		return new DatabaseConnector().execute(connection -> {
			var statement = connection.prepareStatement(queryForReadOne.query);
			statement.setInt(1,id);
			var resultSet = statement.executeQuery();
			return resultSet.next() ? Optional.of(getMapperForRead().map(resultSet)) : Optional.empty();
		});
	}

	public List<T> readAll() {
		return new DatabaseConnector().execute((connection) -> {
			var statement = connection.createStatement();
			var resultSet = statement.executeQuery(queryForReadAll.query);
			var resultList = new ArrayList<T>();
			while (resultSet.next()) resultList.add(getMapperForRead().map(resultSet));
			return resultList;
		});
	}

	public void update(T t) {
		new DatabaseConnector().execute((connection) -> {
			var statement = connection.prepareStatement(queryForUpdate.query);
			getMapperForUpdate().map(t, statement);
			statement.executeQuery();
			return null;
		});
	}

	public void delete(T t) {
		new DatabaseConnector().execute((connection) -> {
			var statement = connection.prepareStatement(queryForDelete.query);
			statement.setInt(1, t.getId().value());
			statement.executeQuery();
			return null;
		});
	}

}
