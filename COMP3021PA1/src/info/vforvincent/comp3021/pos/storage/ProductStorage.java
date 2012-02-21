package info.vforvincent.comp3021.pos.storage;

import info.vforvincent.comp3021.pos.entities.Entity;
import info.vforvincent.comp3021.pos.entities.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ProductStorage extends Storage {

	public ProductStorage(String fileName) {
		super();
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] literals = line.split(" ");
				Product prod = new Product(literals[0], literals[1], Double.valueOf(literals[2]), Integer.valueOf(literals[3]));
				mEntities.put(literals[0], prod);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Product File Not Found");
		}
	}
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return mEntities.containsKey(key);
	}

	public void add(Entity value) {
		// TODO Auto-generated method stub
		mEntities.put(value.getID(), value);
	}
	public Entity get(String key) {
		// TODO Auto-generated method stub
		return mEntities.get(key);
	}

}
