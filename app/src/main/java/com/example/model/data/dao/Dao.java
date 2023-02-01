package com.example.model.data.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	Integer create(T t);
	Optional<T> read(Integer id);
	List<T> readAll();
	void update(T t);
	void delete(T t);

}
