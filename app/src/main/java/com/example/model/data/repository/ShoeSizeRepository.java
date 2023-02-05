package com.example.model.data.repository;

import com.example.model.data.dao.ShoeSizeDao;
import com.example.model.data.dto.ShoeSizeDto;
import com.example.model.entity.ShoeSize;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ShoeSizeRepository implements Repository<ShoeSize, ShoeSizeDto>{

	private final ShoeSizeDao shoeSizeDao = new ShoeSizeDao();

	@Override
	public Optional<ShoeSize> find(Predicate<ShoeSize> condition) {
		return shoeSizeDao.readAll().stream().filter(condition).findFirst();
	}

	@Override
	public List<ShoeSize> getAll() {
		return shoeSizeDao.readAll();
	}

	@Override
	public void add(ShoeSizeDto shoeSizeDto) {
		shoeSizeDao.create(shoeSizeDto);
	}

	@Override
	public void update(ShoeSize shoeSize) {
		shoeSizeDao.update(shoeSize);
	}

	@Override
	public void remove(ShoeSize shoeSize) {
		shoeSizeDao.delete(shoeSize);
	}

}
