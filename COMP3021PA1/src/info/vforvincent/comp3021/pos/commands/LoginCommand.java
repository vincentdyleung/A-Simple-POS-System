package info.vforvincent.comp3021.pos.commands;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

public class LoginCommand extends Command {

	private final String LOGIN_PROMPT = "Please enter your user name: ";
		
	public LoginCommand(Storage users, Log log) {
		super(users, log);
		super.prompt = LOGIN_PROMPT;
	}

	@Override
	public void addLog() {
		// TODO Auto-generated method stub
		logger.add("Non-existent user " + input + ", please enter again!");
	}


}
