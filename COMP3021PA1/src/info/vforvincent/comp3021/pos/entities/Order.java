package info.vforvincent.comp3021.pos.entities;

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
		return mProduct.getPrice() * mQuantity;
	}
	
	@Override
	public String toString() {
		return mProduct.getName() + " * " + mQuantity + " = $" + getTotal();
	}
}
