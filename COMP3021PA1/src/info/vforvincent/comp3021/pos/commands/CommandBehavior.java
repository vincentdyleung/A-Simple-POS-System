package info.vforvincent.comp3021.pos.commands;

import java.util.Scanner;

public interface CommandBehavior {
	
	public void showPrompt();
	
	public void validateInput(Scanner scan);
	
	public void readInput(Scanner scan);
	
	public void addLog();
}
