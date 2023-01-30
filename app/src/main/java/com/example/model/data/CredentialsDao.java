package com.example.model.data;

import com.example.model.entity.Country;
import com.example.model.entity.Credentials;
import com.example.model.entity.Email;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredentialsDao implements Dao<Credentials> {

	private DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public void create(Credentials credentials) {
		// TODO
		throw new RuntimeException("Not implemented");
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
