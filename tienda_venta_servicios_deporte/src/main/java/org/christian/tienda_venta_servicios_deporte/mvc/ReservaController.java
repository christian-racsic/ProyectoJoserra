package org.christian.tienda_venta_servicios_deporte.mvc;

import java.time.LocalDate;
import java.time.LocalTime;
import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.model.Servicio; // Asegúrate de importar la clase Reserva
import org.christian.tienda_venta_servicios_deporte.model.Reservas;
import org.christian.tienda_venta_servicios_deporte.srv.ReservaService; // Asegúrate de tener este servicio
import org.christian.tienda_venta_servicios_deporte.srv.ServicioService; // Importa el servicio de servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService; // Servicio para manejar las reservas

    @Autowired
    private ServicioService servicioService; // Servicio para manejar los servicios

    @RequestMapping(value = "/hacerReservaFinal", method = RequestMethod.POST)
    public String hacerReservaFinal(
            @RequestParam String nombreServicio,
            @RequestParam String fechaReserva,
            @RequestParam String horaReserva,
            @ModelAttribute("cliente") Cliente cliente, // Obtener el cliente desde el modelo
            Model model) {

        // Obtener el servicio usando el nombre
        Servicio servicio = servicioService.obtenerServicioporNombre(nombreServicio);
        
        // Comprobar si el servicio fue encontrado
        if (servicio == null) {
            model.addAttribute("error", "El servicio no se encontró.");
            return "error"; // Redirigir a una vista de error si es necesario
        }

        // Convertir los parámetros a LocalDate y LocalTime
        LocalDate fecha = LocalDate.parse(fechaReserva);
        LocalTime hora = LocalTime.parse(horaReserva);

        // Crear la reserva con el cliente y el servicio
        Reservas reserva = new Reservas(fecha, hora, servicio, cliente);
        reservaService.guardarReserva(reserva,cliente); // Guardar la reserva

        // Mensaje o modelo adicional, si es necesario
        model.addAttribute("mensaje", "Reserva confirmada para el servicio: " + nombreServicio);
        model.addAttribute("cliente", cliente);
        model.addAttribute("reservas", cliente.getReservas());
        return "paginaPrincipal"; // Redirigir a la vista de login o a otra vista que desees
    }
}