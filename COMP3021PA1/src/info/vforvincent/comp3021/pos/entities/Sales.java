package info.vforvincent.comp3021.pos.entities;

import java.util.ArrayList;

public class Sales {
	
	private ArrayList<Order> mOrders;
	private double mPayment = 0.0;
	private static int mID = 0;
	private String mFullID;
	
	public Sales(ArrayList<Order> orders) {
		mFullID = "SalesID" + padID();
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
		return total;
	}
	
	public boolean setPayment(double payment) {
		if (payment < getTotal()) {
			return false;
		} else {
			mPayment = payment;
			return true;
		}
	}
	
	public double getChange() {
		return mPayment - getTotal();
	}

	private String padID() {
		if (mID < 10) {
			return "0" + Integer.toString(mID);
		} else {
			return Integer.toString(mID);
		}
	}
}
