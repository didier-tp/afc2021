package fr.afcepf.al35.tp.web;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import fr.afcepf.al35.tp.service.XyService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Component
//@Named
@ManagedBean

//@Scope("request")
@RequestScoped

@Getter @Setter 
@NoArgsConstructor
public class XyMBean {
	
	private String data;
	private String s;
	private Date date;
	
	//@Autowired
	@Inject
	private XyService xyService;
	
	@PostConstruct
	public void init() {
		//data="blabla";
		data=xyService.getData();
	}
	
	public String doDo() {
		System.out.println("doDo() , s="+s +  " date="+date.toString());
		return null;
	}
	
	
	

}
