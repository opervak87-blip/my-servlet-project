package ca.http.myservlet.controller.command;

import java.util.HashMap;
import java.util.Map;

import ca.http.myservlet.controller.command.impl.GoToIndexPage;
import ca.http.myservlet.controller.command.impl.GoToRegistrationPage;
import ca.http.myservlet.controller.command.impl.Logination;
import ca.http.myservlet.controller.command.impl.Registartion;

public class CommandProvider {
	
private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new Registartion());
		commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());
	}
	
	
	public Command takeCommand(String name) {
		CommandName commandName;
		commandName = CommandName.valueOf(name.toUpperCase());
		return commands.get(commandName);
	}


}
