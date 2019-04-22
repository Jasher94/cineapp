package com.softnar.app.service;

import org.springframework.stereotype.Service;
import com.softnar.app.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService {

	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public NoticiasServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	@Override
	public void guardar(Noticia noticia) {//al pasar el objeto noticia, se esta haciendo uno del data binding
		System.out.println("Guardando el objeto " + noticia + " en la base de datos.");
	}
	
}
