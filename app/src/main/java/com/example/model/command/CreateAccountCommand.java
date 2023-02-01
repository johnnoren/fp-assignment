package com.example.model.command;

import com.example.model.property.*;
import com.example.model.entity.Credentials;
import com.example.model.entity.Country;
import com.example.model.entity.Customer;
import com.example.model.entity.Order;
import com.example.model.entity.Address;
import com.example.model.javafxextension.InputControl;
import com.example.model.property.Number;

import java.util.*;
import java.util.stream.Collectors;

public class CreateAccountCommand implements Command {

	private final CustomerRepository customerRepository = new CustomerRepository();
	private final List<InputControl> controls;

	public CreateAccountCommand(List<InputControl> controls) {
		this.controls = controls;
	}

	@Override
	public Boolean task() {
		customerRepository.
	}

	private Map<String, String> getControlNameValueMap() {
		return controls.stream().collect(Collectors.toMap(InputControl::getName,InputControl::getValue));
	}

	private Customer getCustomerFromControls() {
		var map = getControlNameValueMap();

		var uuid = UUID.randomUUID();
		var firstName = new Name(map.get("First name"));
		var lastName = new Name(map.get("Last name"));
		var email = new Email(map.get("Email"));
		var password = map.get("Password");
		var credentials = Credentials.generate(email,password);
		var street = new Street(map.get("Street"));
		var number = new Number(map.get("Number"));
		var other = new Other(map.get("Other"));
		var city = new City(map.get("City"));
		var postalCode = new PostalCode(map.get("Postal code"));
		var country = new Country(map.get("Country"));
		var address = new Address(street, number, other, postalCode, city, country);
		var orders = new ArrayList<Order>();

		return new Customer(uuid,firstName,lastName,credentials,address,orders);
	}

}