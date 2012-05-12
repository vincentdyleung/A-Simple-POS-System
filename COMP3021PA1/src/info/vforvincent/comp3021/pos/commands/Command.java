package info.vforvincent.comp3021.pos.commands;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Command implements CommandBehavior {

	protected Storage mStorage;
	protected String input;
	protected Log logger;
	protected String prompt;
	
	public Command(Storage storage, Log log) {
		mStorage = storage;
		logger = log;
	}
	
	public void showPrompt() {
		// TODO Auto-generated method stub
		System.out.print(prompt);
	}

	public void validateInput(Scanner scan) {
		// TODO Auto-generated method stub
		while (!mStorage.contains(input)) {
			addLog();
			showPrompt();
			readInput(scan);
		}
	}

	public void readInput(Scanner scan) {
		// TODO Auto-generated method stub
		try {
			input = scan.nextLine();
		} catch (NoSuchElementException e) {
			System.exit(-1);
		}
	}

	public void addLog(){}
	
	public String getInput() {
		return input;
	}

}
