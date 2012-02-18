package info.vforvincent.comp3021.pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class POS {
	
	final static String USER_FILE = "userPasswordFile.txt";
	final static String INVENTORY_FILE = "productListFile.txt";
	final static String LOG_FILE = "logAndSales.txt";
	
	private static ArrayList<User> mUsers = new ArrayList<User>();
	private static HashMap<String, Product> mProducts = new HashMap<String, Product>();
	private static ArrayList<Order> mOrders = new ArrayList<Order>();
	private static Scanner input;
	private static Log logger;
	public static void main(String[] args) {
		try {
			initializeUser(null);
		} catch (FileNotFoundException e) {
			System.err.println("User file not found!");
			System.exit(-1);
		}
		String username = login();
		try {
			initializeInventory();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Product file not found!");
			System.exit(-1);
		}
		printSeparateLine();
		System.out.println("Welcome to Electronic-Sales Counter");
		String choice = readChoice();
		while (!choice.equals("2")) {
			while (!choice.equals("1") && !choice.equals("2")) {
				logger.add("Invalid command");				
				choice = readChoice();
			} 
			if (choice.equals("2")) {
				logoff(username);
			} else if (choice.equals("1")) {
				readOrders();
				printSeparateLine();
				float totalAmountDue = printOrders();
				payCash(totalAmountDue);
			}
			choice = readChoice();
			while (!choice.equals("1") && !choice.equals("2")) {
				logger.add("Invalid command");				
				choice = readChoice();
			} 
		}
	}
	
	private static void initializeUser(String arg) throws FileNotFoundException {
		Scanner userFileScanner = new Scanner(new File(USER_FILE));
		while(userFileScanner.hasNextLine()) {
			String line = userFileScanner.nextLine();
			String[] literals = line.split(" ");
			User user = new User(literals[0], literals[1]);
			mUsers.add(user);
		}
		System.out.println("Welcome to the Point-Of-Sale Registration System");
		userFileScanner.close();
		if (arg == null) {
			input = new Scanner(System.in);
		} else {
			input = new Scanner(new File(arg));
		}
		logger = new Log();
	}
	
	private static void initializeInventory() throws FileNotFoundException {
		Scanner inventoryFileScanner = new Scanner(new File(INVENTORY_FILE));
		while(inventoryFileScanner.hasNextLine()) {
			String line = inventoryFileScanner.nextLine();
			String[] literals = line.split(" ");
			Product prod = new Product(literals[0], literals[1], Float.valueOf(literals[2]), Integer.valueOf(literals[3]));
			mProducts.put(prod.getID(), prod);
		}
	}
	
	private static String readUsername() {
		System.out.print("Please enter your user name: ");
		return input.nextLine();
	}
	
	private static String readPassword() {
		System.out.print("Please enter your password: ");
		return input.nextLine();
	}
	
	private static String readChoice() {
		System.out.print("Please enter '1' to record sales or '2' to exit: ");
		return input.nextLine();
	}
	
	private static String readID() {
		System.out.print("Please enter product ID or press 'c' to end the list: ");
		return input.nextLine();
	}
	
	private static int readAmount(String name) {
		System.out.print("Product name is " + name + ", purchase number: ");
		String num = input.nextLine();
		while (num.matches("[^0-9]+.*") || num.matches("[0-9]+[^0-9]+.*")) {
			System.out.print("Product name is " + name + ", purchase number: ");
			num = input.nextLine();
		}
		return Integer.valueOf(num);
	}
	
	private static void readOrders() {
		System.out.println("Please enter a list of purchasing-product ID and number");
		printSeparateLine();
		String id = readID();
		while (!id.equals("c")) {
			while (!mProducts.containsKey(id)) {
				id = readID();
			}
			int amount = readAmount(mProducts.get(id).getName());
			Order newOrder = new Order(mProducts.get(id), amount);
			mOrders.add(newOrder);
			id = readID();
		}
	}
	
	private static float printOrders() {
		System.out.println("Purchasing-product list:");
		for (Order order : mOrders) {
			System.out.println(order.getProduct().getName() + " * " + order.getQuantity() + " = $" + order.getTotal());
		}
		float total = 0;
		for (Order order : mOrders) {
			total += order.getTotal();
		}
		printSeparateLine();
		System.out.println("The total price is $" + total);
		return total;
	}
	
	private static void payCash(float amount) {
		System.out.print("Please pay with cash, received cash (or cancel by entering '0')$: ");
		float cash = input.nextFloat();
		if (cash == 0) {
			logger.add("SALES" + "cancelled!");
		}
		while (cash < amount) {
			System.out.print("Sorry, cash not enough, please enter cash amount again: ");
			cash = input.nextFloat();
		}
		System.out.println("Change $:" + (cash - amount));
	}
	
	private static String login() {
		String username;
		username = readUsername();
		while (!mUsers.contains(new User(username, ""))) {
			logger.add("Non existent user " + username +", please enter again!");
			username = readUsername();
		}
		String password;
		password = readPassword();
		int i = mUsers.indexOf(new User(username, password));
		while (!mUsers.get(i).isValidUser(username, password)) {
			logger.add("Wrong password for user " + username + ", please enter again!");
			password = readPassword();
		}
		logger.add("Electronic-Sales Counter is started successfully by  user " + username + "!");
		return username;
	}
	
	private static void logoff(String user) {
		System.out.println("User " + user + " has successfully logged off!");
	}
	
	private static void printSeparateLine() {
		System.out.println("---------------------------------------------");
	}
}
