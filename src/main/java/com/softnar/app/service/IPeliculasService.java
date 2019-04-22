package com.softnar.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.softnar.app.model.Pelicula;

public interface IPeliculasService {
	
	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();	
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGenero();
	void eliminar(int idPelicula);
	Page<Pelicula> buscarTodas(Pageable page);

}
