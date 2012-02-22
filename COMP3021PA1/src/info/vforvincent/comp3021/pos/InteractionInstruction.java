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
import info.vforvincent.comp3021.pos.storage.ProductStorage;
import info.vforvincent.comp3021.pos.storage.UserStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractionInstruction implements InstructionMode {

	public void process(UserStorage mUsers, ProductStorage mProducts, Scanner input, Log logger, Sales mSales) {
		// TODO Auto-generated method stub
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
				if (pay == 0) {
					logger.add(mSales.getID() + " cancelled!");
				} else {
					while (!mSales.setPayment(pay)) {
						System.out.print("Sorry, cash not enough, please enter cash amount again: ");
						pay = Double.valueOf(input.nextLine());
					}
					System.out.println("Change $: " + mSales.getChange());
					logger.add(mSales.toString());
				}
				choice.showPrompt();
				choice.readInput(input);
				choice.validateInput(input);
			}
		}
		logger.add("User " + username + " has successfully logged off!");
		System.out.println();
	}
	
	private void printSeparateLine() {
		System.out.println("------------------------------------------------");
	}

}
