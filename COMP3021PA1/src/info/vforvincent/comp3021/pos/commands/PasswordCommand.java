package info.vforvincent.comp3021.pos.commands;

import java.util.NoSuchElementException;
import java.util.Scanner;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

public class PasswordCommand extends Command {
	
	private final String PASSWORD_PROMPT = "Please enter your password: ";
	
	public PasswordCommand(Storage storage, Log log) {
		super(storage, log);
		super.prompt = PASSWORD_PROMPT;
	}
	
	public void validateInput(Scanner scan, String username) {
		String pass = mStorage.get(username).getPassword();
		while (!input.equals(pass)) {
			addLog(username);
			showPrompt();
			try {
				input = scan.nextLine();
			} catch (NoSuchElementException e) {
				System.exit(-1);
			}
		}
	}

	public void addLog(String username) {
		logger.add("Wrong password " + input + " for user " + username + ", please enter again!");
	}

	
}
