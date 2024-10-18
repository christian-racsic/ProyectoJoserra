package org.christian.tienda_venta_servicios_deporte.dto;

public class ClienteDTO {
    private String usuario;
    private String password;
    private String email; // Asegúrate de que esta propiedad exista

    // Constructor
    public ClienteDTO(String usuario, String password, String email) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    // Getters y Setters
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
}