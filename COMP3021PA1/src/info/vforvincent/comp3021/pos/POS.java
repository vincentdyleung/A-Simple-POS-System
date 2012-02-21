package info.vforvincent.comp3021.pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import info.vforvincent.comp3021.pos.entities.Sales;
import info.vforvincent.comp3021.pos.storage.ProductStorage;
import info.vforvincent.comp3021.pos.storage.UserStorage;

public class POS {
	
	public final static String USER_FILE = "userPasswordfile.txt";
	public final static String PRODUCT_FILE = "productListFile.txt";
	public final static String LOG_FILE = "logAndSales.txt";
	
	private static UserStorage mUsers = new UserStorage(USER_FILE);
	private static ProductStorage mProducts = new ProductStorage(PRODUCT_FILE);
	private static Scanner input;
	private static Log logger = new Log(LOG_FILE);
	private static Sales mSales;
	private static Executor execute = new Executor();
	
	public static void main(String[] args) {
		if (args.length == 0) {
			input = new Scanner(System.in);
			execute.setMode(new InteractionInstruction());
		} else {
			try {
				input = new Scanner(new File(args[0]));
				execute.setMode(new FileInstruction());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Input File Not Found");
			}
		}
		
		execute.getMode().process(mUsers, mProducts, input, logger, mSales);
	}
}
