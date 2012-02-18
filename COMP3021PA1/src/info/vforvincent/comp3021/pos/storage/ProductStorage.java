package info.vforvincent.comp3021.pos.storage;

import info.vforvincent.comp3021.pos.entities.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ProductStorage implements Storage {

	private HashMap<String, Product> mProducts;
	
	public ProductStorage(String fileName) {
		mProducts = new HashMap<String, Product>();
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] literals = line.split(" ");
				Product prod = new Product(literals[0], literals[1], Double.valueOf(literals[2]), Integer.valueOf(literals[3]));
				mProducts.put(literals[0], prod);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Product File Not Found");
		}
	}
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		return mProducts.containsKey((String) key);
	}

	public void add(Object value) {
		// TODO Auto-generated method stub
		mProducts.put(((Product) value).getID(), (Product) value);
	}
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return mProducts.get(key);
	}

}
