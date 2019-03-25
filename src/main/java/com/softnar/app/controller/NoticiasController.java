package com.softnar.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softnar.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticia"; 
	}
	
	
	@PostMapping(value="/save")
	public String  guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus,
			@RequestParam("detalle") String detalle){
		
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setEstatus(estatus);
		noticia.setDetalle(detalle);
		
		//Pendiente Guardar el objeto notiica en la base de datos
		
		System.out.println(noticia);
		
		return "noticias/formNoticia";
		
	}

}
