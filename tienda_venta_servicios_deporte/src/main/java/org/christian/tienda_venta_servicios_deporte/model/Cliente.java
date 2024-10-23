package org.christian.tienda_venta_servicios_deporte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Cliente  implements Serializable{
	private static final long SerialVersionUID = 1L;
	private Integer id;
    @Size(min=3, message="El nombre debe de tener mínimo 3 letras")
    @NotNull(message = "No puede estar vacio el nombre")
	private String usuario;
    @NotNull(message = "No puede estar vacio lac contraseña")
    @Size(min=9, message="La contraseña debe de tener mínimo 9 carácteres")
    private String password;
    @NotNull(message = "No puede estar vacio el correo")
    private String email;
    private List<Reservas> reservas;
    
    
	public Cliente(Integer id, String usuario, String password, String email) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		 this.reservas = new ArrayList<>();
		
	}
	
	
	public Cliente(String usuario, String password, String email) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		
	}


	public Cliente() {
		super();
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
	public List<Reservas> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}
	public void agregarReserva(Reservas reserva) {
        reservas.add(reserva);
    }
    
}
