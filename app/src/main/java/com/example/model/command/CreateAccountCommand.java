package com.example.model.command;

import com.example.model.javafxextension.InputControl;

import java.util.List;

public class CreateAccountCommand implements Command {

	private final CustomerRepository customerRepository = new CustomerRepository();
	private final List<InputControl> controls;

	public CreateAccountCommand(List<InputControl> controls) {
		this.controls = controls;
	}

	@Override
	public Boolean task() {
		return null;
	}

}
