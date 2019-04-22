package com.softnar.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softnar.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
	
	//select * from Noticias
	List<Noticia> findBy();
	
	//select * from Noticias where estatus = ? 
	List<Noticia> findByEstatus(String estatus);
	
	//where fecha = ?
	List<Noticia> findByFecha(Date fecha);
	
	//Where  estatus=? and fecha=?
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	//where estatus=? or fecha =?
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);

	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);

}
