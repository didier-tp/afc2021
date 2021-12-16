package tp.webServices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.webServices.dto.LoginRequest;
import tp.webServices.dto.LoginResponse;
import tp.webServices.util.JwtTokenProvider;



@RestController
@RequestMapping(value="/devise-api/public/login" , headers="Accept=application/json")
public class LoginRestCtrl {
	
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	//http://localhost:8484/webServices/devise-api/public/login
	//avec { "username" : "user1" , "password" : "pwd1" }
	//en retour { "message" :  "..." , "token" ; "..." , ...}
	@PostMapping("")
	public ResponseEntity<LoginResponse> postLogin(@RequestBody LoginRequest loginRequest){
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUsername(loginRequest.getUsername());
		/* if(loginRequest.getUsername().equals("user1") && 
				loginRequest.getPassword().equals("pwd1")) */
		try {
		Authentication authentication = null;
		//vérifier le username/password avec SpringSecurity:
		authentication=authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(
		                loginRequest.getUsername(),
		                loginRequest.getPassword()
		        ));//authenticate() soulève une exception si mauvais username ou password
			loginResponse.setOk(true);
			loginResponse.setMessage("successful login");
			loginResponse.setToken(jwtTokenProvider.generateToken(authentication));
		}catch(Exception ex) {
			loginResponse.setOk(false);
			loginResponse.setMessage("login failed");
			return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.OK);
	}

}

