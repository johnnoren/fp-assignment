package com.example.model.data;

import com.example.model.entity.Credentials;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CredentialsRepository implements Repository<Credentials>{

	private final Dao<Credentials> dao = new CredentialsDao();

	@Override
	public Optional<Credentials> find(Predicate<Credentials> condition) {
		return dao.readAll().stream().filter(condition).findFirst();
	}

	@Override
	public List<Credentials> getAll() {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void add(Credentials credentials) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void update(Credentials credentials) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void remove(Credentials credentials) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

}
