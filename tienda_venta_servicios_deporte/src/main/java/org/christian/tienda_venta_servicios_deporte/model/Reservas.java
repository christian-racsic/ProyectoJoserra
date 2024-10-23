package org.christian.tienda_venta_servicios_deporte.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public class Reservas implements Serializable{
	private static final long SerialVersionUID = 1L;
	private Long id = 0L;
	@NotNull(message = "La fecha de reserva no puede estar vacía")
    @FutureOrPresent(message = "La fecha debe ser hoy o una fecha futura")
    private LocalDate fecha;

    @NotNull(message = "La hora de reserva no puede estar vacía")
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
	
	public Reservas() {
		super();
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
