package br.edu.ifsc.ui.db;

import br.edu.ifsc.ui.entities.User;
import javafx.collections.ObservableList;

public interface UserDBInterface {

	public User getUser(String username);

	public ObservableList<User> getUsers();
	
	public void changePass(String username, String newPass);
	
	public void addUser(String username, String pass);
	
}
