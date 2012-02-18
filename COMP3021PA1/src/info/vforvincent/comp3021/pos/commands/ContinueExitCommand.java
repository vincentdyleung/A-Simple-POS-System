package info.vforvincent.comp3021.pos.commands;

import java.util.Scanner;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

public class ContinueExitCommand extends Command {
	
	private final String CONTINUE_EXIT_PROMPT = "Please enter '1' to record sales or '2' to exit: ";

	public ContinueExitCommand(Storage storage, Log log) {
		super(storage, log);
		// TODO Auto-generated constructor stub
		super.prompt = CONTINUE_EXIT_PROMPT;
	}
	
	@Override
	public void validateInput(Scanner scan) {
		while (!input.equals("1") && !input.equals("2")) {
			addLog();
			showPrompt();
			readInput(scan);
		}
	}
	
	@Override
	public void addLog() {
		logger.add("Invalid command");
	}

}
