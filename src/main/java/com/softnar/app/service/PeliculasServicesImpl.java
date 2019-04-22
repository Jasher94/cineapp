package com.softnar.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.softnar.app.model.Pelicula;

//@Service
public class PeliculasServicesImpl implements IPeliculasService{

	private List<Pelicula> lista = null;
	public   PeliculasServicesImpl() {
		
		System.out.println("Creando una instancia de la clase PeliculasServiceImpl");
		// TODO Auto-generated constructor stub
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
		try {
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventuta");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2019"));
			//pelicula1.setImagen("cinema.png");
			
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo(" La Bella y la Bestia  ");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A"); 
			pelicula2.setGenero("infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2019"));
			pelicula2.setImagen("bella.png");
			

			Pelicula pelicula3 = new Pelicula(); 
			pelicula3.setId(3);
			pelicula3.setTitulo(" Contra Tiempo ");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B"); 
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2019"));
			pelicula3.setImagen("contratiempo.png");
			
			Pelicula pelicula4 = new Pelicula(); 
			pelicula4.setId(4);
			pelicula4.setTitulo(" Kong la isla Calavera ");
			pelicula4.setDuracion(116);
			pelicula4.setClasificacion("B"); 
			pelicula4.setGenero("Thriller");
			pelicula4.setFechaEstreno(formatter.parse("28-05-2019"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");
			
			Pelicula pelicula5 = new Pelicula(); 
			pelicula5.setId(5);
			pelicula5.setTitulo(" Life: vida inteligente ");
			pelicula5.setDuracion(126);
			pelicula5.setClasificacion("A"); 
			pelicula5.setGenero("Thriller");
			pelicula5.setFechaEstreno(formatter.parse("06-06-2019"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");
			
			//Agregamos los objetos pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			
			 
		}catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Error:"+e.getMessage());
			 
		}
	}
	@Override
	public List<Pelicula> buscarTodas() {
		
		return lista;
	}
	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p:lista) {
			if(p.getId() == idPelicula) {
				return p;
			}			
		}
		return null;
	}
	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		
	}
	@Override
	public List<String> buscarGenero() {
		// TODO Auto-generated method stub
		//NOTA: Esta lista podria ser obtenida de una BD
		List<String> generos = new LinkedList<>();
		generos.add("Action");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		return generos;
	}

}
