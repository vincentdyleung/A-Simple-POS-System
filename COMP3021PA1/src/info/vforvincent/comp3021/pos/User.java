package info.vforvincent.comp3021.pos;


public class User {
	private String mName;
	private String mPassword;
	
	public User(String name, String password) {
		mName = name;
		mPassword = password;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getPassword() {
		return mPassword;
	}
	
	public boolean isValidUser(String name, String password){
		return (mName.equals(name) && mPassword.equals(password));
	}
	
	@Override
	public boolean equals(Object u) {
		if (mName.equals(((User) u).getName())) {
			return true;
		} else {
			return false;
		}
	}
	
}
