package org.christian.tienda_venta_servicios_deporte.srv;

import java.util.ArrayList;
import java.util.List;

import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	 private static int idCounter = 1;
	
	static {
		clientes.add(new Cliente(1,"admin", "admin", "admin@admin.es"));
		clientes.add(new Cliente(2,"usuario2", "password2", "usuario2@example.com"));
		clientes.add(new Cliente(3,"usuario3", "password3", "usuario3@example.com"));
		clientes.add(new Cliente(4,"usuario4", "password4", "usuario4@example.com"));
		idCounter = clientes.size() + 1;
	}
	
	public Cliente validarClienteInicio(String correo, String password) {
	    return clientes.stream()
	        .filter(cliente -> cliente.getEmail().equals(correo) && cliente.getPassword().equals(password))
	        .findFirst()
	        .orElse(null);
	}
	
	public Cliente validarAdmin(String correo, String password) {
	    return clientes.stream()
	        .filter(cliente -> cliente.getEmail().equals("admin@admin.es") && cliente.getPassword().equals("admin"))
	        .findFirst()
	        .orElse(null);
	}
	
	public List<Cliente> listarClientes(){
		return clientes;
	}
	
	public boolean validarRegistro(String correo) {
		for(Cliente client : clientes) {
			if(client.getEmail().equalsIgnoreCase(correo)) {
				return true;
			}
		}
		
		return false;
			
	}
	
	public  Cliente nuevoCliente(String usuario, String correo, String contraseña) {
		
		Cliente nuevoCliente = new Cliente(idCounter++, usuario, contraseña, correo);
        
        clientes.add(nuevoCliente);
        
        return nuevoCliente;
	}
	
	
	
}
