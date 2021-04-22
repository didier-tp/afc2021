package fr.afcepf.al35.web.model;

import java.util.List;

public class LoginBean {
	
	private String username;
	private String password;
	private User user=null;
	private String message;
	
	private List<User> validUsers;
	
	public boolean loginUser() {
		//...
	}

	public LoginBean() {
		validUsers.add(new User("toto" , "pwdtoto" , "toto@ici.fr"));
		validUsers.add(new User("titi" , "pwdtiti" , "titi@la.fr"));
	}

}
