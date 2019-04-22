package com.softnar.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.springframework.web.bind.annotation.RequestParam;

import com.softnar.app.model.Horario;
import com.softnar.app.model.Pelicula;
import com.softnar.app.service.IBannersService;
import com.softnar.app.service.IHorariosService;
//import com.softnar.app.service.IBannersService;
import com.softnar.app.service.IPeliculasService;
import com.softnar.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
	
	@Autowired 
	private IBannersService serviceBanners; // Ejercicio : Solucion
	
	@Autowired
	private IHorariosService serviceHorarios;
	 
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	//HAce busqueda de la fecha
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam ("fecha") String fecha, Model model) {
		System.out.println("Buscando todas las peliculas en Exhibicion para la fecha"+ fecha);
		List<String> listaFechas = Utileria.getNextDays(4);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda",fecha);
		model.addAttribute("peliculas", peliculas); 
		model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion
		
		
		return "home";		
	}
	
	
	//modelo que almacena la lista de peliculas
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		
				
		List<Pelicula> peliculas =  servicePeliculas.buscarTodas();
		/*
		 * peliculas.add("Rapidos y furiosos"); 
		 * peliculas.add("El aro 2");
		 * peliculas.add("Aliens");
		 */
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas); 
	    model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion

		return "home";
		
	}
	
	//@RequestMapping(value="/detail/{id}/{fecha}",method=RequestMethod.GET)
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	//public String mostrarDetalle(Model model,@PathVariable("id")int idPelicula, @PathVariable("fecha")  String fecha) {
	public String mostrarDetalle(Model model,@RequestParam("idMovie")int idPelicula, @RequestParam("fecha")  Date fecha) {
	
		System.out.println("Buscando Horario para la Pelicula: " + idPelicula);
		System.out.println("Para la Fecha: " + fecha);
		
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda",dateFormat.format(fecha));
		model.addAttribute("pelicula",servicePeliculas.buscarPorId(idPelicula));
		
		//TODO - Buscar en la base de datos los horarios
		
		//Codigo necesario para ver la busqueda
		
		
		
		return "detalle";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
// Metodo para generar una lista de objetos de modelo {Pelicula|
	

	
}
