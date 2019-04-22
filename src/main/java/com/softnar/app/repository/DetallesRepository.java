package com.softnar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softnar.app.model.Detalle;

@Repository	
public interface DetallesRepository extends JpaRepository<Detalle, Integer> {

}
