package br.edu.ifsc.ui.db;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.ui.entities.User;

public class GetUserXML implements GetUserInterface {

	@Override
	public User getUser(String username) {
		
		if (username.equals("xml"))
			return new User("xml", "123");
		else
			return null;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("xml1", "123"));
		users.add(new User("xml2", "123"));
		return users;
	}

}
