package com.example.model.data.daoOLD;

import com.example.model.data.dto.Dto;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	void create(Dto<T> t);
	Optional<T> read(Integer id);
	List<T> readAll();
	void update(T t);
	void delete(T t);

}
