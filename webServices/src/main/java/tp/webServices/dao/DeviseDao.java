package tp.webServices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.webServices.entity.Devise;

public interface DeviseDao extends JpaRepository<Devise,String> {

}
