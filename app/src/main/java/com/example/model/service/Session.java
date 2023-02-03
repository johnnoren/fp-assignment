package com.example.model.service;

import com.example.model.entity.Id;

public class Session {

	private static Session session;
	private Id currentUser;

	private Session(Id currentUser){
		this.currentUser = currentUser;
	};

	public static void setCurrentUser(Id userId) {
		 if (session == null) {
			 session = new Session(userId);
		 } else {
			 session.currentUser = userId;
		 }
	 }

	 public Id getCurrentUser() {
		return currentUser;
	 }

}
