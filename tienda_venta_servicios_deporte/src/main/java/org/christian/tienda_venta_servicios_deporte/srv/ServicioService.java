package org.christian.tienda_venta_servicios_deporte.srv;

import java.util.ArrayList;

import org.christian.tienda_venta_servicios_deporte.model.Servicio;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {
	 static ArrayList <Servicio> servicios = new ArrayList<>();
	 
	 static {
		    servicios.add(new Servicio("Natación", "./img/natacion.jpg"));
		    servicios.add(new Servicio("Pádel", "./img/padel.jpg"));
		    servicios.add(new Servicio("Tenis", "./img/tenis.jpg"));
		    servicios.add(new Servicio("Gym", "./img/gym.jpg"));
		    servicios.add(new Servicio("Crossfit", "./img/crosfit.jpg"));
		    servicios.add(new Servicio("Boxeo", "./img/boxeo.jpg"));
		}

	    public ArrayList<Servicio> obtenerServicios() {
	        return servicios;
	    }
	    
	    public Servicio obtenerServicioporNombre(String nombre) {
	        return servicios.stream()
	                .filter(servicio -> servicio.getNombre().equalsIgnoreCase(nombre))
	                .findFirst()
	                .orElse(null);
	    }
	    
	    
	    
	 
}
