package com.softnar.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import com.softnar.app.model.Pelicula;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	//modelo que almacena la lista de peliculas
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<Pelicula> peliculas =  getLista();
		/*
		 * peliculas.add("Rapidos y furiosos"); peliculas.add("El aro 2");
		 * peliculas.add("Aliens");
		 */
		model.addAttribute("peliculas", peliculas); 
		
		return "home";
		
	}
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapidos y Furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		
		return "detalle";
	}
	
	
	
// Metodo para generar una lista de objetos de modelo {Pelicula|
	
	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		List<Pelicula> lista = null;
		try {
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventuta");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2019"));
			pelicula1.setImagen("cinema.png");
			
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo(" La Bella y la Bestia  ");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A"); 
			pelicula2.setGenero("infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2019"));
			pelicula2.setImagen("bella.jpg");
			

			Pelicula pelicula3 = new Pelicula(); 
			pelicula3.setId(3);
			pelicula3.setTitulo(" Contra Tiempo ");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B"); 
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2019"));
			pelicula3.setImagen("contratiempo.jpg");
			
			Pelicula pelicula4 = new Pelicula(); 
			pelicula4.setId(4);
			pelicula4.setTitulo(" Kong la isla Calavera ");
			pelicula4.setDuracion(116);
			pelicula4.setClasificacion("B"); 
			pelicula4.setGenero("Thriller");
			pelicula4.setFechaEstreno(formatter.parse("28-05-2019"));
			pelicula4.setImagen("kong.jpg");
			pelicula4.setEstatus("Inactiva");
			
			//Agregamos los objetos pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			
			return lista;
		}catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Error:"+e.getMessage());
			return null;
		}
	}
	
}
