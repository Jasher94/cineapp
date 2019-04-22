package com.softnar.app.service;

import java.util.List;

import com.softnar.app.model.Banner; 

public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	
}
