package fr.afcepf.al35.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.afcepf.al35.web.model.User;

public class UserDao {

	public UserDao() {
	}
	
	private static DataSource ds;
	
	private static void initDataSource() {
		if(ds==null) {
			String dsName = "java:comp/env/jdbc/myDB";
			// Nom logique JNDI
			// Obtention via JNDI de l'objet DataSource:
			try {
				InitialContext ic = new InitialContext();
				ds = (DataSource) ic.lookup(dsName);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<User> rechercherValidUsers() {
		 List<User> listeUsers = new ArrayList<>();
		 //...
		 return listeUsers;
	}

}
