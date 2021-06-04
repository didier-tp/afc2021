package fr.afcepf.al35.tp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class LoginResponse {
	private String username;
	private Boolean ok; //true or false
	private String message; // "authentification réussie" ou "echec ...."
	private String token; //jwt ou autre
	
	public LoginResponse(String username, Boolean ok, String message, String token) {
		super();
		this.username = username;
		this.ok = ok;
		this.message = message;
		this.token = token;
	}
	
	
}

