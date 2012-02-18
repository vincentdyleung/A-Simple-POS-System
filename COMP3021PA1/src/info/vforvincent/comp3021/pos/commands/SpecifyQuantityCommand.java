package info.vforvincent.comp3021.pos.commands;

import java.util.Scanner;

import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.storage.Storage;

public class SpecifyQuantityCommand extends Command {

	public SpecifyQuantityCommand(Storage storage, Log log, String productName) {
		super(storage, log);
		// TODO Auto-generated constructor stub
		super.prompt = "Product name is " + productName + ", purchase number: ";
	}
	
	@Override
	public void validateInput(Scanner scan) {
		
	}

}
