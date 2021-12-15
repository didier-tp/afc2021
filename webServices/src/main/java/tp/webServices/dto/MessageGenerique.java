package tp.webServices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class MessageGenerique {
	
	public String message;
	public String details;
	
	public MessageGenerique(String message) {
		this.message =message;
	}

}
