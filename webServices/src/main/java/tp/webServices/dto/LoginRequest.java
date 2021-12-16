package tp.webServices.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString() @NoArgsConstructor
public class LoginRequest {
	private String username;
	private String password;
	//private String roles;
	
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
