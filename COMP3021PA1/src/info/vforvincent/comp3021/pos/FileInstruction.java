package info.vforvincent.comp3021.pos;

import info.vforvincent.comp3021.pos.commands.AddProductCommand;
import info.vforvincent.comp3021.pos.commands.ContinueExitCommand;
import info.vforvincent.comp3021.pos.commands.LoginCommand;
import info.vforvincent.comp3021.pos.commands.PasswordCommand;
import info.vforvincent.comp3021.pos.commands.PaymentCommand;
import info.vforvincent.comp3021.pos.commands.SpecifyQuantityCommand;
import info.vforvincent.comp3021.pos.entities.Order;
import info.vforvincent.comp3021.pos.entities.Product;
import info.vforvincent.comp3021.pos.entities.Sales;
import info.vforvincent.comp3021.pos.entities.User;
import info.vforvincent.comp3021.pos.storage.ProductStorage;
import info.vforvincent.comp3021.pos.storage.UserStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class FileInstruction implements InstructionMode {

	public void process(UserStorage mUsers, ProductStorage mProducts,
			Scanner input, Log logger, Sales mSales) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Point-Of-Sale Registration System");
		
		LoginCommand login = new LoginCommand(mUsers, logger);
		login.showPrompt();
		login.readInput(input);
		String username = login.getInput();
		if (!mUsers.contains(username)) {
			logger.add("Non-existent user " + username);
			return;
		}
		
		PasswordCommand pass = new PasswordCommand(mUsers, logger);
		pass.showPrompt();
		pass.readInput(input);
		String password = ((User) mUsers.get(username)).getPassword();
		if (!pass.getInput().equals(password)) {
			logger.add("Wrong password " + pass.getInput() + " user " + username);
			return;
		}
		
		logger.add("Electronic-Sales Counter is started successfully by user " + username + "!");
		printSeparateLine();
		System.out.println("Welcome to the Electronic-Sales Counter!");
		
		ContinueExitCommand choice = new ContinueExitCommand(mUsers, logger);
		choice.showPrompt();
		choice.readInput(input);
		if (!choice.getInput().equals("1") && !choice.getInput().equals("2")) {
			logger.add("Invalid input");
			return;
		}
		while (!choice.getInput().equals("2")) {
			if (choice.getInput().equals("1")) {
				AddProductCommand addProduct = new AddProductCommand(mProducts, logger);
				ArrayList<Order> orderBuffer = new ArrayList<Order>();
				addProduct.showPrompt();
				addProduct.readInput(input);
				if (!mProducts.contains(addProduct.getInput()) && !addProduct.getInput().equals("c")) {
					logger.add("Incorrect product ID");
					System.exit(-1);
				}
			
				while (!addProduct.getInput().equals("c")) {	
					Product product = (Product) mProducts.get(addProduct.getInput());
					String productName = product.getName();
					SpecifyQuantityCommand specifyQuantity = new SpecifyQuantityCommand(mProducts, logger, productName);
					specifyQuantity.showPrompt();
					specifyQuantity.readInput(input);
					try {
						Integer.parseInt(specifyQuantity.getInput());
					} catch (NumberFormatException e) {
						logger.add("Incorrect number");
						System.exit(-1);
					}
					int quantity = Integer.valueOf(specifyQuantity.getInput());
					Order order = new Order(product, quantity);
					orderBuffer.add(order);
				
					addProduct.showPrompt();
					addProduct.readInput(input);
					if (!mProducts.contains(addProduct.getInput()) && !addProduct.getInput().equals("c")) {
						logger.add("Incorrect product ID");
						System.exit(-1);
					}
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
				if (!mSales.setPayment(pay)) {
					logger.add("Cash not enough!");
					System.exit(-1);
				}
				System.out.println("Change $: " + mSales.getChange());
				choice.showPrompt();
				choice.readInput(input);
				if (!choice.getInput().equals("1") && !choice.getInput().equals("2")) {
					logger.add("Invalid input");
					System.exit(-1);
				}
			}
		}
		logger.add("User " + username + " has successfully logged off!");
		printSeparateLine();
		System.out.println();
	}
	
	private void printSeparateLine() {
		System.out.println("------------------------------------------------");
	}

}
