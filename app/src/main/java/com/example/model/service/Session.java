package com.example.model.service;

import com.example.model.entity.Id;

import java.util.UUID;

public class Session {

	private static Session session;
	private Id currentUserId = new Id(0);
	private Id currentCustomerId = new Id(0);
	private UUID currentOrderNumber = UUID.randomUUID();

	private Session(){};

	public static Session getSession() {
		if (session == null) {
			session = new Session();
		}

		return session;
	}

	public void setCurrentUserId(Id currentUserId) {
		this.currentUserId = currentUserId;
	}

	public void setCurrentCustomerId(Id currentCustomerId) {
		this.currentCustomerId = currentCustomerId;
	}

	public void setCurrentOrderNumber(UUID currentOrderNumber) {
		this.currentOrderNumber = currentOrderNumber;
	}

	public Id getCurrentUserId() {
		return currentUserId;
	}

	public Id getCurrentCustomerId() {
		return currentCustomerId;
	}

	public UUID getCurrentOrderNumber() {
		return currentOrderNumber;
	}

}
