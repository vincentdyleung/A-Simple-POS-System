package info.vforvincent.comp3021.pos.storage;

import info.vforvincent.comp3021.pos.entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UserStorage implements Storage {

	private HashMap<String, User> mUsers;
	
	public UserStorage(String fileName) {
		mUsers = new HashMap<String, User>();
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] literals = line.split(" ");
				User user = new User(literals[0], literals[1]);
				mUsers.put(literals[0], user);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("User File Not Found");
		}
	}
	
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		return mUsers.containsKey((String) key);
	}

	public void add(Object value) {
		// TODO Auto-generated method stub
		mUsers.put(((User) value).getName(), (User) value);
	}
	
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return mUsers.get(key);
	}

}
