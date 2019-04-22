package com.softnar.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.softnar.app.model.Contacto;
import com.softnar.app.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService servicePelicula;
		
		@GetMapping("/contacto")
		public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto, Model model) {
			model.addAttribute("generos",servicePelicula.buscarGenero());
			model.addAttribute("tipos",tipoNotificacion());
			return "formContacto";
		}
		
		@PostMapping("/contacto")
		public String guardar(@ModelAttribute("instanciaContacto")  Contacto contacto) {
			
			//Este objeto ya se podria almacenar en una DB
			System.out.println(contacto);
			return "redirect:/contacto";
		}
		
		private List<String> tipoNotificacion(){
			//Nota: LA lista se podria Generar apartir de una BD
			List<String> tipos = new LinkedList<String>();
			tipos.add("Estrenos");
			tipos.add("Promociones");
			tipos.add("Noticias");
			tipos.add("Preventas");
			
			return tipos;
			
			
		}
}
