package info.vforvincent.comp3021.pos.entities;

public class User extends Entity {
	private String mName;
	private String mPassword;
	
	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		mName = username;
		mPassword = password;
	}

	public String getName() {
		return mName;
	}
	
	public String getPassword() {
		return mPassword;
	}
}
