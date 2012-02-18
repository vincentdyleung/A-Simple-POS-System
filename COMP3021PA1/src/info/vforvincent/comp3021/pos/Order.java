package info.vforvincent.comp3021.pos;

public class Order {
	
	private Product mProduct;
	private int mQuantity;
	
	public Order(Product prod, int quantity) {
		mProduct = prod;
		mQuantity = quantity;
	}
	
	public float getTotal() {
		return mProduct.getPrice() * mQuantity;
	}
	
	public Product getProduct() {
		return mProduct;
	}
	
	public int getQuantity() {
		return mQuantity;
	}
}
