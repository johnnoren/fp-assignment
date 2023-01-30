package com.example.model.data;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T> {
	Optional<T> get(Predicate<T> condition);
	List<T> getAll();
	void add(T t);
	void update(T t);
	void remove(T t);
}
