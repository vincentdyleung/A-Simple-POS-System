package info.vforvincent.comp3021.pos.entities;

import java.text.DecimalFormat;

public class Order extends Entity {
	
	private Product mProduct;
	private int mQuantity;
	
	public Order(Product prod, int quantity) {
		mProduct = prod;
		mQuantity = quantity;
	}
	
	public Product getProduct() {
		return mProduct;
	}
	
	public int getQuantity() {
		return mQuantity;
	}
	
	public double getTotal() {
		double total = mProduct.getPrice() * mQuantity;
		DecimalFormat df = new DecimalFormat("##.0");
		return Double.valueOf(df.format(total));
	}
	
	@Override
	public String toString() {
		return padSpaceToLength(mProduct.getName() + " * " + mQuantity, 16 ) + "= $" + getTotal();
	}
	
	private String padSpaceToLength(String s, int length) {
		if (s.length() >= length) {
			return s + "\t";
		} else {
			StringBuilder builder = new StringBuilder(s);
			for (int i = 0; i < length - s.length(); i++) {
				builder.append(' ');
			}
			return builder.toString();
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
