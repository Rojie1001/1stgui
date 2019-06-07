package br.edu.ifsc.ui.entities;

public class User {
	private String name;
	private String pass;
	private boolean isAdmin;

	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
		this.isAdmin = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
