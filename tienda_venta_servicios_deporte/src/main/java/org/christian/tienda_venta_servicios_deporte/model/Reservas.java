package org.christian.tienda_venta_servicios_deporte.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Reservas {
	private Long id = 0L;
    private LocalDate fecha;
    private LocalTime tiempo;
    private Servicio servicio;
    private Cliente cliente;
    private List<Reservas> reservas = new ArrayList<>();
    
    
	public Reservas(LocalDate fecha, LocalTime tiempo, Servicio servicio, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.tiempo = tiempo;
		this.servicio = servicio;
		this.cliente = cliente;
	}
	public List<Reservas> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getTiempo() {
		return tiempo;
	}
	public void setTiempo(LocalTime tiempo) {
		this.tiempo = tiempo;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    
}
