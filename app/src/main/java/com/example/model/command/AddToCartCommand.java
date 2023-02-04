package com.example.model.command;

public class AddToCartCommand implements Command {

	@Override
	public Boolean task() {
		System.out.println("Change!");
		return false;
	}

}
