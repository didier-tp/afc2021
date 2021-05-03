package tp.core.bs;

import javax.ejb.Local;

@Local
public interface BasicService {
	String sayHello(String username);
}
