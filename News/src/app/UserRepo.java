package app;

import java.util.ArrayList;
import java.util.List;

import app.observer.User;

public class UserRepo {

	private List<User> users;

	public UserRepo() {
		this.users = new ArrayList<>();
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void addUsers(User... inputUsers) {
		for (User user : inputUsers)
			this.users.add(user);
	}
}
