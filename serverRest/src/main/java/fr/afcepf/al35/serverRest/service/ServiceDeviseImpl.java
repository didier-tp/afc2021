package fr.afcepf.al35.serverRest.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al35.serverRest.dao.DaoDevise;
import fr.afcepf.al35.serverRest.entity.Devise;
import fr.afcepf.al35.serverRest.exception.MyAlreadyExistingEntityException;
import fr.afcepf.al35.serverRest.exception.MyEntityNotFoundException;


@Service //ou @Stateless sur projet EJB
@Transactional
public class ServiceDeviseImpl implements ServiceDevise{
	
	@Autowired
	private DaoDevise daoDevise;

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		Devise deviseSource = daoDevise.findById(codeDeviseSource).get();
		Devise deviseCible = daoDevise.findById(codeDeviseCible).get();
		return montant * deviseCible.getChange() / deviseSource.getChange();
	}


	@Override
	public List<Devise> rechercherDevises() {
		return daoDevise.findAll();
	}
	
	@Override
	public List<Devise> rechercherDevisesParChangeMini(Double changeMini) {
		return daoDevise.findByChangeGreaterThanEqual(changeMini);
	}

	@Override
	public Devise rechercherDeviseParCode(String code) throws MyEntityNotFoundException{
		try {
			return daoDevise.findById(code).get();//retourne exception si Optional empty
			                             //.orElse(null)
		} catch (Exception e) {
			//e.printStackTrace();
			throw new MyEntityNotFoundException("devise pas trouvée pour code="+code);
		}
	}

	@Override
	public Devise createDevise(Devise d) {
		if(daoDevise.existsById(d.getCode()))
			throw new MyAlreadyExistingEntityException("devise déjà existante avec code="+d.getCode());
		else return  daoDevise.save(d);
	}

	@Override
	public void updateDevise(Devise d) {
		if(daoDevise.existsById(d.getCode()))
			daoDevise.save(d);
		else
			throw new MyEntityNotFoundException("devise inexistante (pas modifiable) pour code="+d.getCode());
	}

	@Override
	public void deleteDevise(String code) {
		if(daoDevise.existsById(code))
		    daoDevise.deleteById(code);
		else
			throw new MyEntityNotFoundException("devise inexistante (pas supprimable) pour code="+code);
			
	}

}
