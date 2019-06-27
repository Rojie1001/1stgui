package br.edu.ifsc.ui.util;

import br.edu.ifsc.ui.db.UserDBInterface;
import br.edu.ifsc.ui.db.AdminUser;

public class DB {
	public static UserDBInterface users = new AdminUser();
}
