package com.example.model.command;

import com.example.model.data.dto.CustomerDto;
import com.example.model.data.repository.CustomerRepository;
import com.example.model.javafxextension.InputControl;
import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateAccountCommand implements Command {

	private final CustomerRepository customerRepository = new CustomerRepository();
	private final List<InputControl> controls;

	public CreateAccountCommand(List<InputControl> controls) {
		this.controls = controls;
	}

	@Override
	public Boolean task() {
		customerRepository.add(getCustomerDtoFromControls());
		return false;
	}

	private Map<String, String> getControlNameValueMap() {
		return controls.stream().collect(Collectors.toMap(InputControl::getName,InputControl::getValue));
	}

	private CustomerDto getCustomerDtoFromControls() {
		var map = getControlNameValueMap();
		var salt = new Salt();
		var hashedPassword = new HashedPassword(map.get("Password"), salt);
		return new CustomerDto(
				map.get("First modelName"),
				map.get("Last modelName"),
				map.get("Email"),
				salt.value,
				hashedPassword.value,
				map.get("Street"),
				map.get("Number"),
				map.get("Other"),
				map.get("Postal code"),
				map.get("City"),
				map.get("Country")
		);
	}

}