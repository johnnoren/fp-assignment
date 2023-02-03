package com.example.model.data.repository;

import com.example.model.data.dto.Dto;
import com.example.model.entity.Identifiable;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T extends Identifiable, R extends Dto<T>> {
	Optional<T> find(Predicate<T> condition);
	List<T> getAll();
	void add(R r);
	void update(T t);
	void remove(T t);
}
