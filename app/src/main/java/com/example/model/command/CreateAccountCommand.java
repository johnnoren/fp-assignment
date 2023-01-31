package com.example.model.command;

import com.example.model.data.CredentialsRepository;

public class CreateAccountCommand implements Command {

	private final CredentialsRepository repo = new CredentialsRepository();


	@Override
	public Boolean task() {
		
	}

}
