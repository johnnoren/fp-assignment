package com.example.model.data.dao;

import com.example.model.data.dto.CredentialsDto;
import com.example.model.entity.Credentials;
import com.example.model.entity.Id;
import com.example.model.property.Email;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

public class CredentialsDao extends Dao<Credentials, CredentialsDto>{

	public CredentialsDao() {
		super(Sql.CREATE_CREDENTIALS, Sql.READ_ONE_CREDENTIALS, Sql.READ_ALL_CREDENTIALS, Sql.UPDATE_CREDENTIALS,
				Sql.DELETE_CREDENTIALS);
	}

	@Override
	protected DtoToStatementMapper<CredentialsDto> getMapperForCreate() {
		return (credentialsDto, statement) -> {
			statement.setString(1, credentialsDto.email());
			statement.setString(2, credentialsDto.salt());
			statement.setString(3, credentialsDto.hashedPassword());
		};
	}

	@Override
	protected ResultSetToEntityMapper<Credentials> getMapperForRead() {
		return (resultSet -> new Credentials(
				new Id(resultSet.getInt(1)),
				new Email(resultSet.getString(2)),
				new Salt(resultSet.getString(3)),
				new HashedPassword(resultSet.getString(4))));
	}

	@Override
	protected EntityToStatementMapper<Credentials> getMapperForUpdate() {
		return (credentials, statement) -> {
			statement.setString(1, credentials.email().value());
			statement.setString(2, credentials.salt().value);
			statement.setString(3, credentials.hashedPassword().value);
			statement.setInt(3, credentials.id().value());
		};
	}

}
