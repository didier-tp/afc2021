package fr.afcepf.al35.serverRest.test;

//pour assertTrue (res==5) au lieu de Assertions.assertTrue(res==5)
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.afcepf.al35.serverRest.ServerRestApplication;
import fr.afcepf.al35.serverRest.dao.DaoDevise;
import fr.afcepf.al35.serverRest.entity.Devise;
import fr.afcepf.al35.serverRest.service.ServiceDevise;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {ServerRestApplication.class})
@ActiveProfiles({"mock-dao"})
public class TestServiceDeviseWithDaoMock {
	
	@Autowired
	private ServiceDevise serviceDevise; //à tester
	
	@Autowired
	private DaoDevise daoDeviseMock; //mock à utiliser
	
	@BeforeEach
	public void reInitMock() {
		//vérification que le dao injecté est bien un mock		
		assertTrue(Mockito.mockingDetails(daoDeviseMock).isMock());
		//reinitialisation du mock(de scope=Singleton par defaut) sur aspects stub et spy 
		Mockito.reset(daoDeviseMock);
	}
	
	@Test
	public void testRechercherDevises() {
		//préparation du mock (qui sera utilisé en arrière plan du service à tester):
		List<Devise> devises = new ArrayList<>();
		devises.add(new Devise("EUR","Euro",1.0));
		devises.add(new Devise("USD","Dollar",1.1));
		Mockito.when(daoDeviseMock.findAll()).thenReturn(devises);
		//vérification du résultat du service
		List<Devise> listeDevises = serviceDevise.rechercherDevises();
		System.out.println("listeDevises="+listeDevises);
		assertTrue(listeDevises.size()==2);
		//vérifier si le service a appeler 1 fois findAll() en interne sur le dao:
		Mockito.verify(daoDeviseMock, Mockito.times(1)).findAll();
	}
	
	@Test
	public void testRechercherDeviseParCode() {
		//préparation du mock (qui sera utilisé en arrière plan du service à tester):
		Devise d = new Devise("Ms","Monnaie de singe",1234.567);
		Mockito.when(daoDeviseMock.findById("Ms")).thenReturn(Optional.of(d));
		//vérification du résultat du service
		Devise deviseRemontee  = serviceDevise.rechercherDeviseParCode("Ms");
		System.out.println("deviseRemontee="+deviseRemontee);
		assertEquals(deviseRemontee.getNom(),"Monnaie de singe");
		//vérifier si le service a appeler 1 fois findById() en interne sur le dao:
		Mockito.verify(daoDeviseMock, Mockito.times(1)).findById(Mockito.anyString());
	}
	
	@Test
	public void testRechercherDeviseParCode2() {
		//préparation du mock (qui sera utilisé en arrière plan du service à tester):
		Devise d = new Devise("Ms2","Monnaie de singe 2",1234.567);
		Mockito.when(daoDeviseMock.findById("Ms2")).thenReturn(Optional.of(d));
		//vérification du résultat du service
		Devise deviseRemontee  = serviceDevise.rechercherDeviseParCode("Ms2");
		System.out.println("deviseRemontee(2)="+deviseRemontee);
		assertEquals(deviseRemontee.getNom(),"Monnaie de singe 2");
		//vérifier si le service a appeler 1 fois findById() en interne sur le dao:
		Mockito.verify(daoDeviseMock, Mockito.times(1)).findById(Mockito.anyString());
	}
	
	

}
