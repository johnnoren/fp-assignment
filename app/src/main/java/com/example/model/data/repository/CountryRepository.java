package com.example.model.data.repository;

import com.example.model.data.dao.CountryDao;
import com.example.model.data.daoOLD.Dao;
import com.example.model.entity.Country;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CountryRepository implements Repository<Country>{

	private final Dao<Country> countryDao = new CountryDao();

	@Override
	public Optional<Country> find(Predicate<Country> condition) {
		return countryDao.readAll().stream().filter(condition).findFirst();
	}

	@Override
	public List<Country> getAll() {
		return dao.readAll();
	}

	@Override
	public void add(Country country) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void update(Country country) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void remove(Country country) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

}
