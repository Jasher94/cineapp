package com.softnar.app.model;
 
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Noticias")
public class Noticia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	@Column(name = "fecha",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String detalle;
	private String estatus;
	
	
	public Noticia() {
		System.out.println("Contructor Noticia");
		this.fecha = new Date( );
		this.estatus = "Activa";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		System.out.println("Set Titulo");
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDetalle() {

		System.out.println("Set detalle");
		return detalle;
	}


	public void setDetalle(String detalle) {

		System.out.println("Set estatus");
		this.detalle = detalle;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}	

}
