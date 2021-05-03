package tp.web.mbean;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import tp.core.bs.CompteService;

@ManagedBean //de JSF
@RequestScoped
public class CompteMBean {
	
	//@EJB
	@Inject
	private CompteService compteService;

	public CompteMBean() {
		// TODO Auto-generated constructor stub
	}

}
