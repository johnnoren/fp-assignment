package com.example.model.data.repository;

import com.example.model.data.dao.CredentialsDao;
import com.example.model.data.dao.Dao;
import com.example.model.data.dto.CredentialsDto;
import com.example.model.entity.Credentials;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CredentialsRepository implements Repository<Credentials, CredentialsDto>{

	private final Dao<Credentials, CredentialsDto> credentialsDao = new CredentialsDao();

	@Override
	public Optional<Credentials> find(Predicate<Credentials> condition) {
		return credentialsDao.readAll().stream().filter(condition).findFirst();
	}

	@Override
	public List<Credentials> getAll() {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void add(CredentialsDto credentialsDto) {
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
