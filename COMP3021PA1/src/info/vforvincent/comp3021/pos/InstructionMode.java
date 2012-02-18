package info.vforvincent.comp3021.pos;

import info.vforvincent.comp3021.pos.entities.Sales;
import info.vforvincent.comp3021.pos.storage.ProductStorage;
import info.vforvincent.comp3021.pos.storage.UserStorage;

import java.util.Scanner;

public interface InstructionMode {
	
	public void process(UserStorage mUsers, ProductStorage mProducts, Scanner input, Log logger, Sales mSales);

}
