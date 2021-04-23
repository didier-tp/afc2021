package fr.afcepf.al35.web.model;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al35.dao.UserDao;

public class LoginBean {
	
	private String username;
	private String password;
	private User user=null;
	private String message;
	
	private List<User> validUsers;
	
	public boolean loginUser() {
		boolean ok=false;
		for(User u : this.validUsers) {
			if( this.username.equals(u.getUsername()) 
				&& this.password.equals(u.getPassword()) ) {
				this.user=u;
				this.message = "sucessful login";
				ok=true;
			}
		}
		if(!ok) {
			this.message = "login fail";
		}
		return ok;
	}

	public LoginBean() {
		/*
		validUsers = new ArrayList<User>();
		validUsers.add(new User("toto" , "pwdtoto" , "toto@ici.fr"));
		validUsers.add(new User("titi" , "pwdtiti" , "titi@la.fr"));
		*/
		validUsers = UserDao.rechercherValidUsers();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
