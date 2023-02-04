package com.example.model.data.dao;

import com.example.model.data.dto.ShoeDto;
import com.example.model.entity.*;
import com.example.model.property.*;
import com.example.model.property.Number;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class ShoeDao extends Dao<Shoe, ShoeDto> {

	public ShoeDao() {
		super(Sql.CREATE_SHOE, Sql.READ_ONE_SHOE, Sql.READ_ALL_SHOES, Sql.UPDATE_SHOE, Sql.DELETE_SHOE);
	}

	@Override
	protected DtoToStatementMapper<ShoeDto> getMapperForCreate() {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected ResultsetToEntityMapper<Shoe> getMapperForRead() {
		return (resultSet -> new Shoe(
				new Id(resultSet.getInt(1)),
				UUID.fromString(resultSet.getString(2)),
				new Price(resultSet.getInt(3)),
				new StockLevel(resultSet.getInt(4)),
				new ShoeSize(
						new Id(resultSet.getInt(5)),
						new EuropeanSize(resultSet.getDouble(6))),
				new Style(
						new Id(resultSet.getInt(7)),
						new StyleName(resultSet.getString(8)),
						new ProductImage(new File(resultSet.getString(9))),
						new Model(
								new Id(resultSet.getInt(10)),
								new ModelName(resultSet.getString(11)),
								new ModelDescription(resultSet.getString(12)),
								new Brand(
										new Id(resultSet.getInt(13)),
										new BrandName(resultSet.getString(14))),
								new ArrayList<>()),
						new ArrayList<>())));
	}

	@Override
	protected EntityToStatementMapper<Shoe> getMapperForUpdate() {
		// TODO
		throw new RuntimeException("Not implemented");
	}

}
