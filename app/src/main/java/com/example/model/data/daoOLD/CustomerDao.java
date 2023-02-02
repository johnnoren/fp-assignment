package com.example.model.data.daoOLD;

import com.example.model.data.dao.DatabaseConnector;
import com.example.model.entity.Customer;
import com.example.model.entity.Shoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer>{

	private DatabaseConnector databaseConnector = new DatabaseConnector();

	@Override
	public Integer create(Customer customer) {






		return databaseConnector.execute((connection) -> {
			var sqlQuery = """

                                insert into Address(Street, Number, Other, PostalCode, City, CountryId) values (_street,_number,_other,_postalCode,_city,country_id);""";
			var statement = connection.prepareStatement(sqlQuery);
			statement.setString(1,model + "%");
			var resultSet = statement.executeQuery();
			var shoeList = new ArrayList<Shoe>();
			while (resultSet.next()) {
				shoeList.add(new Shoe(
								resultSet.getInt("Id"),
								resultSet.getInt("Price"),
								resultSet.getInt("StockLevel"),
								resultSet.getString("Style"),
								resultSet.getString("Model"),
								resultSet.getString("Brand")
						)
				);
			}





	}

	@Override
	public Optional<Customer> read(Integer id) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Customer> readAll() {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void update(Customer customer) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void delete(Customer customer) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

}
