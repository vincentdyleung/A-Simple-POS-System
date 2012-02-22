package info.vforvincent.comp3021.pos.storage;

import info.vforvincent.comp3021.pos.entities.Entity;
import info.vforvincent.comp3021.pos.entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserStorage extends Storage {
	
	public UserStorage(String fileName) {
		super();
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] literals = line.split(" ");
				User user = new User(literals[0], literals[1]);
				mEntities.put(literals[0], user);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("User File Not Found");
		}
	}
	
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return mEntities.containsKey(key);
	}

	public void add(Entity value) {
		// TODO Auto-generated method stub
		mEntities.put(value.getName(), value);
	}
	
	public Entity get(String key) {
		// TODO Auto-generated method stub
		return mEntities.get(key);
	}

}
