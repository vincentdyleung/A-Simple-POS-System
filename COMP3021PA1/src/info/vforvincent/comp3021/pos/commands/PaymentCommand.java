package info.vforvincent.comp3021.pos.commands;

import java.util.NoSuchElementException;
import java.util.Scanner;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

public class PaymentCommand extends Command {

	private final String PAYMENT_PROMPT = "Please pay with cash, received cash (or cancel by entering '0')$: ";
	
	public PaymentCommand(Storage storage, Log log) {
		super(storage, log);
		// TODO Auto-generated constructor stub
		super.prompt = PAYMENT_PROMPT;
	}
	
	@Override
	public void validateInput(Scanner scan) {
		while (!input.matches("\\d+") && !input.matches("\\d+.\\d+")) {
			showPrompt();
			try {
				input = scan.nextLine();
			} catch (NoSuchElementException e) {
				System.exit(-1);
			}
			
		}
	}

	@Override
	public void addLog() {
		// TODO Auto-generated method stub
		
	}

}
