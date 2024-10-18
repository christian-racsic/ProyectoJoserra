package org.christian.tienda_venta_servicios_deporte.srv;

import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.model.Reservas;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
	public void guardarReserva(Reservas reserva, Cliente cliente) {
		cliente.getReservas().add(reserva);
	}
}
