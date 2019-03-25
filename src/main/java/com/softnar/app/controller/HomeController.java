package com.softnar.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.springframework.web.bind.annotation.RequestParam;

import com.softnar.app.model.Pelicula;
import com.softnar.app.util.Utileria;

@Controller
public class HomeController {


	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	//HAce busqueda de la fecha
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam ("fecha") String fecha, Model model) {
		System.out.println("Buscando todas las peliculas en Exhibicion para la fecha"+ fecha);
		List<String> listaFechas = Utileria.getNextDays(4);
		
		
		List<Pelicula> peliculas =  getLista();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda",fecha);
		model.addAttribute("peliculas", peliculas); 
		
		return "home";		
	}
	
	
	//modelo que almacena la lista de peliculas
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		
				
		List<Pelicula> peliculas =  getLista();
		/*
		 * peliculas.add("Rapidos y furiosos"); 
		 * peliculas.add("El aro 2");
		 * peliculas.add("Aliens");
		 */
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas); 
		return "home";
		
	}
	
	//@RequestMapping(value="/detail/{id}/{fecha}",method=RequestMethod.GET)
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	//public String mostrarDetalle(Model model,@PathVariable("id")int idPelicula, @PathVariable("fecha")  String fecha) {
	public String mostrarDetalle(Model model,@RequestParam("idMovie")int idPelicula, @RequestParam("fecha")  String fecha) {
	
		System.out.println("Buscando Horario para la Pelicula: " + idPelicula);
		System.out.println("Para la Fecha: " + fecha);
		
		//TODO - Buscar en la base de datos los horarios
		
		//Codigo necesario para ver la busqueda
		
		/*
		 * String tituloPelicula = "Rapidos y Furiosos"; int duracion = 136; double
		 * precioEntrada = 50;
		 * model.addAttribute("titulo", tituloPelicula); model.addAttribute("duracion",
		 * duracion); model.addAttribute("precio", precioEntrada);
		 */
		
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
			
			return lista;
		}catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Error:"+e.getMessage());
			return null;
		}
	}
	
}
