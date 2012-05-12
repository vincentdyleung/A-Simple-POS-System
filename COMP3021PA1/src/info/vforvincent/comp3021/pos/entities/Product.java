package info.vforvincent.comp3021.pos.entities;

public class Product extends Entity{
	
	private String mID;
	private String mName;
	private double mPrice;
	private int mStock;
	
	public Product(String id, String name, double price, int stock) {
		mID = id;
		mName = name;
		mPrice = price;
		mStock = stock;
	}
	
	public String getID() {
		return mID;
	}
	
	public String getName() {
		return mName;
	}
	
	public double getPrice() {
		return mPrice;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
