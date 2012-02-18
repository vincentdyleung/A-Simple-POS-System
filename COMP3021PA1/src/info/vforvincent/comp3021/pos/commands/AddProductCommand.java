package info.vforvincent.comp3021.pos.commands;

import java.util.Scanner;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

public class AddProductCommand extends Command {
	
	private final String PRODUCT_PROMPT = "Please enter product ID or press 'c' to end the list: ";
	
	public AddProductCommand(Storage products, Log log) {
		super(products, log);
		super.prompt = PRODUCT_PROMPT;
	}
	
	public void validateInput(Scanner scan) {
		// TODO Auto-generated method stub
		while (!mStorage.contains(input) && !input.equals("c")) {
			addLog();
			showPrompt();
			readInput(scan);
		}
	}

	public void addLog() {
		// TODO Auto-generated method stub
		
	}

}
