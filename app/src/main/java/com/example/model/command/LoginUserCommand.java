package com.example.model.command;

import com.example.model.data.repository.CredentialsRepository;
import com.example.model.property.Email;
import com.example.model.service.SceneSwitcher;
import com.example.model.service.Session;
import javafx.event.Event;

public class LoginUserCommand implements Command {

	private final CredentialsRepository credentialsRepository = new CredentialsRepository();
	private final Email userEmail;
	private final Event event;

	public LoginUserCommand(Email userEmail, Event event) {
		this.userEmail = userEmail;
		this.event = event;
	}

	@Override
	public Boolean task() {
		var credentials =
				credentialsRepository.find(credentials1 -> credentials1.email().value().equals(userEmail.value())).get();

		Session.getSession().setCurrentUserId(credentials.id());

		if (credentials.admin()) {
			new SceneSwitcher().switchTo(event, SceneSwitcher.SceneId.REPORTS);
			return true;
		}

		return false;
	}

}
