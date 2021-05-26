package fr.afcepf.al35.tp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.afcepf.al35.tp.entity.Client;
import fr.afcepf.al35.tp.service.ClientService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
   
	
	@Autowired
	private ClientService clientService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String password=null;
		if(username.equals("superAdmin")) {
			password=passwordEncoder.encode("007");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		else {
			try {
				Long numCli = Long.parseLong(username);
				Client cli = clientService.rechercherClientParNumero(numCli);
				authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
				password=cli.getPassword();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return new User(username, password, authorities);
	} 

}
