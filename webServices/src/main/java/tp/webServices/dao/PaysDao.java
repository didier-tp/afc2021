package tp.webServices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.webServices.entity.Pays;

public interface PaysDao  extends JpaRepository<Pays,String> {

}
