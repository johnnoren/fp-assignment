package com.example.model.command;

@FunctionalInterface
public interface Command {
	default Boolean execute(Boolean abort) {
		return abort ? true : task();
	};

	Boolean task();

	default Boolean execute() {
		 return execute(false);
	};

	default Command andThen(Command later) {
		return () -> later.execute(execute());
	}

}
