package fr.afcepf.al35.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		 initDataSource();
		 Connection cn =null;
		 try {
			cn  = ds.getConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User");
			while(rs.next()) {
				listeUsers.add(new User(rs.getString("username"),
						                rs.getString("password"),
						                rs.getString("email")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{ cn.close(); //libérer connexion logique dans le pool
			                 //pour quelle puisse être recyclé
			} catch(Exception e) { }
		}
		 return listeUsers;
	}

}
