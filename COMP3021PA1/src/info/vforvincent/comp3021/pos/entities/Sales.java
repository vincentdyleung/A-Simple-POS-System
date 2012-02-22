package info.vforvincent.comp3021.pos.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Sales extends Entity {
	
	private ArrayList<Order> mOrders;
	private double mPayment = 0.0;
	private static int mID = 0;
	private String mFullID;
	
	public Sales(ArrayList<Order> orders) {
		mFullID = "SalesID" + pad(mID++);
		mOrders = orders;
	}
	
	public void addOrder(Order order) {
		mOrders.add(order);
	}
	
	public String getID() {
		return mFullID;
	}
	
	public double getTotal() {
		double total = 0.0;
		for (Order order : mOrders) {
			total += order.getTotal();
		}
		DecimalFormat df = new DecimalFormat("##.0");
		return Double.valueOf(df.format(total));
	}
	
	public boolean setPayment(double payment) {
		if (payment < getTotal()) {
			return false;
		} else {
			mPayment = payment;
			return true;
		}
	}
	
	public String toString() {
		String output =  mFullID + "\ttotal $" + Double.toString(getTotal()) + ";";
		int length = mOrders.size();
		for (int i = 0; i < length; i++ ) {
			output += mOrders.get(i).getProduct().getName() + " " + mOrders.get(i).getQuantity();
			if (i < length - 1) {
				output += ";";
			}
		}
		return output;
	}
	
	public double getChange() {
		double change = mPayment - getTotal();
		DecimalFormat df = new DecimalFormat("##.0");
		return Double.valueOf(df.format(change));
	}

	private String pad(int i) {
		if (i < 10) {
			return "0" + Integer.toString(i);
		} else {
			return Integer.toString(i);
		}
	}
}
