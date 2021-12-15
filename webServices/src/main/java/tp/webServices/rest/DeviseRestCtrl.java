package tp.webServices.rest;

import tp.webServices.entity.Devise;
import tp.webServices.service.DeviseService;

//bonnes annotations
public class DeviseRestCtrl {
	
	private DeviseService deviseService;

	public DeviseRestCtrl(DeviseService deviseService) {
		//injection de dépendance par constructeur
		this.deviseService = deviseService;
	}
	
	
	//V2: DeviseDto getDevisesByCriteria(...) {
	Devise getDevisesByCriteria(...) {
		
	}
	
	//CRUD (POST , GET , PUT , DELETE)

}
