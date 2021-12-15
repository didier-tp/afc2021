package tp.webServices.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tp.webServices.dao.DeviseDao;
import tp.webServices.entity.Devise;

@Service
@Transactional
public class DeviseServiceImpl implements DeviseService {
	
	private DeviseDao deviseDao;

	public DeviseServiceImpl(DeviseDao deviseDao) {
		//injection de dépendance par constructeur 
		//(plutot que via @Autowired)
		this.deviseDao = deviseDao; 
	}

	@Override
	public Devise rechercherDeviseParCode(String code) {
		return deviseDao.getById(code);
	}

	@Override
	public List<Devise> rechercherToutesDevises() {
		return deviseDao.findAll();
	}

	@Override
	public void supprimerDeviseParCode(String code) {
		deviseDao.deleteById(code);
	}

	@Override
	public void sauvegarderDevise(Devise d) {
       deviseDao.save(d);
	}

	@Override
	public boolean existeOuPas(String code) {
		return deviseDao.existsById(code);
	}

}
