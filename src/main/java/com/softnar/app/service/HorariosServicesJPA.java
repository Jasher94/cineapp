package com.softnar.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.softnar.app.model.Horario;
import com.softnar.app.repository.HorariosRepository;


@Service
public class HorariosServicesJPA implements IHorariosService{
	
	@Autowired
	private HorariosRepository horariosRepo;
	
	
	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
		
	}
	
	

}
