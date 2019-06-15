package br.edu.ifsc.ui.db;

import java.util.ArrayList;

import br.edu.ifsc.ui.entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserXML implements UserDBInterface {

	private static ObservableList<User> users;

	@Override
	public User getUser(String username) {
		users = getUsers();
		for (User user : users)
			if (user.getName().contentEquals(username))
				return user;
		return null;
	}

	@Override
	public ObservableList<User> getUsers() {
		if (users == null) {
			users = FXCollections.observableArrayList(new ArrayList<User>());
			users.add(new User("admin", "admin"));
		}
		return users;
	}

	@Override
	public void changePass(String username, String newPass) {
		User user = getUser(username);
		user.setPass(newPass);
	}
	
	@Override
	public void addUser(String username, String pass) {
		getUsers().add(new User(username, pass));
	}
}
