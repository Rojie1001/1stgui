package br.edu.ifsc.ui.db;

import java.util.List;

import br.edu.ifsc.ui.entities.User;

public interface GetUserInterface {

	public User getUser(String username);

	public List<User> getUsers();
}
