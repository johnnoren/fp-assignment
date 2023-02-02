package com.example.model.data.daoOLD;

import com.example.model.data.dao.DatabaseConnector;
import com.example.model.entity.Credentials;
import com.example.model.property.Email;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredentialsDao implements Dao<Credentials> {

	private DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public Integer create(Credentials credentials) {
		return databaseConnector.execute((connection) -> {
			var sqlQuery = "insert into Credentials (Id, Email, PasswordSalt, PasswordHash) values (?, ?, ?, ?)";
			var statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,credentials.id().value());
			statement.setString(2,credentials.email().value());
			statement.setString(3, credentials.salt().value);
			statement.setString(4, credentials.hashedPassword().value);
			statement.executeUpdate();
			return statement.getGeneratedKeys().getInt(1);
		});
	}

	@Override
	public Optional<Credentials> read(Integer id) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Credentials> readAll() {
		return databaseConnector.execute((connection) -> {
			var statement = connection.createStatement();
			var sqlQuery = """
					select Email, PasswordSalt, PasswordHash from Credentials;""";
			var resultSet = statement.executeQuery(sqlQuery);
			var resultList = new ArrayList<Credentials>();
			while (resultSet.next()) {
				resultList.add(new Credentials(
								new Email(resultSet.getString("Email")),
								new Salt(resultSet.getString("PasswordSalt")),
						new HashedPassword(resultSet.getString("PasswordHash"))
						)
				);
			}
			return resultList;
		});
	}

	@Override
	public void update(Credentials credentials) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void delete(Credentials credentials) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

}
