package com.softnar.app.service;

import java.util.Date;
import java.util.List;

import com.softnar.app.model.Horario;

public interface IHorariosService {

	List<Horario> buscarPorIdPelicula(int idPelicula, Date date);
}
