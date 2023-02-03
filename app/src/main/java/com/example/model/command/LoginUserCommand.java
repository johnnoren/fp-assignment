package com.example.model.command;

import com.example.model.data.repository.CredentialsRepository;
import com.example.model.property.Email;
import com.example.model.service.Session;

public class LoginUserCommand implements Command {

	private final CredentialsRepository credentialsRepository = new CredentialsRepository();
	private final Email userEmail;

	public LoginUserCommand(Email userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public Boolean task() {
		var credentialsId =
				credentialsRepository.find(credentials -> credentials.email().value().equals(userEmail.value())).get().id();
		Session.setCurrentUser(credentialsId);
		return false;
	}

}
