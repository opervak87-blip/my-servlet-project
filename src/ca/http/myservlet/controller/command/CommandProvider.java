package ca.http.myservlet.controller.command;

import java.util.HashMap;
import java.util.Map;

import ca.http.myservlet.controller.command.impl.GoToDropMenuDetails;
import ca.http.myservlet.controller.command.impl.GoToIndexPage;
import ca.http.myservlet.controller.command.impl.GoToLoginPage;
import ca.http.myservlet.controller.command.impl.GoToRegistrationPage;
import ca.http.myservlet.controller.command.impl.LoginUser;
import ca.http.myservlet.controller.command.impl.LogoutUser;
import ca.http.myservlet.controller.command.impl.SaveNewUser;

public class CommandProvider {
	
private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOLOGINPAGE, new GoToLoginPage());
		commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());
		commands.put(CommandName.GOTODROPMENUDETAILS, new GoToDropMenuDetails());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.LOGINUSER, new LoginUser());
		commands.put(CommandName.LOGOUTUSER, new LogoutUser());
	}
	
	
	public Command takeCommand(String name) {
		CommandName commandName;
		commandName = CommandName.valueOf(name.toUpperCase());
		return commands.get(commandName);
	}


}
