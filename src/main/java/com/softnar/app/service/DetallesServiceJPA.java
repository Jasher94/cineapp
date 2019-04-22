package com.softnar.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softnar.app.model.Detalle;
import com.softnar.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService{

	@Autowired
	private DetallesRepository detallesRepo;
	
	@Override
	public void insertar(Detalle detalle) {
		detallesRepo.save(detalle);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idDetalle) {
		detallesRepo.deleteById(idDetalle);
		
	}
	
	

}
