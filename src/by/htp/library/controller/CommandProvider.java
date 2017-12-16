package by.htp.library.controller;

import by.htp.library.controller.command.Command;
import by.htp.library.controller.command.impl.AddBookCommand;
import by.htp.library.controller.command.impl.InformationAboutAll;
import by.htp.library.controller.command.impl.LoginationCommand;
import by.htp.library.controller.command.impl.RegistrationComand;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("add_book", new AddBookCommand());
		commands.put("logination", new LoginationCommand());
		commands.put("registration", new RegistrationComand());
		commands.put("getAll", new InformationAboutAll());
	}

	Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;

	}

}
