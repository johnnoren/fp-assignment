package com.example.model.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	void create(T t);
	Optional<T> read(Integer id);
	List<T> readAll();
	void update(T t);
	void delete(T t);

}
