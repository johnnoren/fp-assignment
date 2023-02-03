package com.example.model.data.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

class DatabaseConnector {
	private final Properties p = new Properties();

	@FunctionalInterface
	public interface DatabaseInteractor<T> {
		T apply(Connection connection) throws Exception;
	}

	protected DatabaseConnector() {
		try {
			p.load(new FileInputStream(DatabaseConnector.class.getResource("/com/example/settings.properties").getFile()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected <T> T execute(DatabaseInteractor<T> function) {
		try (Connection connection = DriverManager.getConnection(p.getProperty("connectionString"),
				p.getProperty("name"),
				p.getProperty("password"))
		) {
			return function.apply(connection);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
