package info.vforvincent.comp3021.pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import info.vforvincent.comp3021.pos.commands.AddProductCommand;
import info.vforvincent.comp3021.pos.commands.ContinueExitCommand;
import info.vforvincent.comp3021.pos.commands.LoginCommand;
import info.vforvincent.comp3021.pos.commands.PasswordCommand;
import info.vforvincent.comp3021.pos.commands.PaymentCommand;
import info.vforvincent.comp3021.pos.commands.SpecifyQuantityCommand;
import info.vforvincent.comp3021.pos.entities.Order;
import info.vforvincent.comp3021.pos.entities.Product;
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
	
	public static void main(String[] args) {
		if (args.length == 0) {
			input = new Scanner(System.in);
		} else {
			try {
				input = new Scanner(new File(args[0]));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Input File Not Found");
			}
		}
		while (true) {
			process();
		}
	}

	public static void printSeparateLine() {
		System.out.println("------------------------------------------------");
	}
	
	public static void process() {
		System.out.println("Welcome to the Point-Of-Sale Registration System");
		
		LoginCommand login = new LoginCommand(mUsers, logger);
		login.showPrompt();
		login.readInput(input);
		login.validateInput(input);
		String username = login.getInput();
		
		PasswordCommand pass = new PasswordCommand(mUsers, logger);
		pass.showPrompt();
		pass.readInput(input);
		pass.validateInput(input, username);
		
		logger.add("Electronic-Sales Counter is started successfully by user " + username + "!");
		printSeparateLine();
		System.out.println("Welcome to the Electronic-Sales Counter!");
		
		ContinueExitCommand choice = new ContinueExitCommand(mUsers, logger);
		choice.showPrompt();
		choice.readInput(input);
		choice.validateInput(input);
		while (!choice.getInput().equals("2")) {
			if (choice.getInput().equals("1")) {
				AddProductCommand addProduct = new AddProductCommand(mProducts, logger);
				ArrayList<Order> orderBuffer = new ArrayList<Order>();
				addProduct.showPrompt();
				addProduct.readInput(input);
				addProduct.validateInput(input);
			
				while (!addProduct.getInput().equals("c")) {	
					Product product = (Product) mProducts.get(addProduct.getInput());
					String productName = product.getName();
					SpecifyQuantityCommand specifyQuantity = new SpecifyQuantityCommand(mProducts, logger, productName);
					specifyQuantity.showPrompt();
					specifyQuantity.readInput(input);
					specifyQuantity.validateInput(input);
					int quantity = Integer.valueOf(specifyQuantity.getInput());
					Order order = new Order(product, quantity);
					orderBuffer.add(order);
				
					addProduct.showPrompt();
					addProduct.readInput(input);
					addProduct.validateInput(input);
				} 
			
				printSeparateLine();
				System.out.println("Purchasing-product list:");
				double total = 0.0;
				for (Order order : orderBuffer) {
					System.out.println(order.toString());
					total += order.getTotal();
				}
				System.out.println("The total price is $" + total);
				mSales = new Sales(orderBuffer);
			
				PaymentCommand payment = new PaymentCommand(mProducts, logger);
				payment.showPrompt();
				payment.readInput(input);
				payment.validateInput(input);
				double pay = Double.valueOf(payment.getInput());
				while (!mSales.setPayment(pay)) {
					System.out.print("Sorry, cash not enough, please enter cash amount again: ");
					pay = Double.valueOf(input.nextLine());
				}
				System.out.println("Change $: " + mSales.getChange());
				choice.showPrompt();
				choice.readInput(input);
				choice.validateInput(input);
			}
		}
		logger.add("User " + username + " has successfully logged off!");
		printSeparateLine();
		System.out.println();
	}
}
