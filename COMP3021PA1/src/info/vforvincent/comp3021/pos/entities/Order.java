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
		return mProduct.getName() + " * " + mQuantity + " = $" + getTotal();
	}
}
