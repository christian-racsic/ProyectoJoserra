package org.christian.tienda_venta_servicios_deporte.model;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
	private String nombre;
	private String imagen;
	private List<Reservas> reservas;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Reservas> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Servicio(String nombre) {
		super();
		this.nombre = nombre;
		this.reservas = new ArrayList<Reservas>();
	}
	public Servicio(String nombre, String imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.reservas = new ArrayList<Reservas>();
	}
	
	
	
}
