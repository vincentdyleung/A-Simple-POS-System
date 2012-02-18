package info.vforvincent.comp3021.pos;

public class Product {
	
	private String mID;
	private String mName;
	private float mPrice;
	private int mAmount;
	
	public Product(String id, String name, float price, int amount) {
		mID = id;
		mName = name;
		mPrice = price;
		mAmount = amount;
	}

	public String getID() {
		return mID;
	}
	
	public String getName() {
		return mName;
	}
	
	public float getPrice() {
		return mPrice;
	}
	
	@Override
	public String toString() {
		return mID + "\t" + mName + "\t" + mPrice + "\t" + mAmount;
	}
	
	@Override
	public boolean equals(Object p) {
		return mID.equals(((Product) p).getID());
	}
}
