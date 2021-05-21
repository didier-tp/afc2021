package fr.afcepf.al35.tp.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al35.tp.entity.Client;

public interface ClientDao {
   Optional<Client> findById(Long id); 
   Client save(Client c);
   void deleteById(Long id);
}
