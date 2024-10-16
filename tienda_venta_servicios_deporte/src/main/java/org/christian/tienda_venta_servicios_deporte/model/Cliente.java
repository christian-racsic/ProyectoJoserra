package org.christian.tienda_venta_servicios_deporte.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private Integer id;
    private String usuario;
    private String password;
    private String email;
    private List<Reservas> reservations;
    
    
	public Cliente(Integer id, String usuario, String password, String email) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.reservations = new ArrayList<Reservas>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Reservas> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservas> reservations) {
		this.reservations = reservations;
	}
    
    
}
