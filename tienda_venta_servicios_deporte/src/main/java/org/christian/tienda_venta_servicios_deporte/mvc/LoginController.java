package org.christian.tienda_venta_servicios_deporte.mvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.christian.tienda_venta_servicios_deporte.dto.ClienteDTO;
import org.christian.tienda_venta_servicios_deporte.mapper.ClienteMapper;
import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.model.Reservas;
import org.christian.tienda_venta_servicios_deporte.model.Servicio;
import org.christian.tienda_venta_servicios_deporte.srv.ClienteService;
import org.christian.tienda_venta_servicios_deporte.srv.ReservaService;
import org.christian.tienda_venta_servicios_deporte.srv.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
@Controller
@SessionAttributes("cliente")
public class LoginController {
    @Autowired
    ClienteService clienteService;
    @Autowired
    ServicioService servicioService;
    @Autowired
    ReservaService reservaService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginControler() {
        return "login";
    }
    Cliente cliente = null;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String procesaLogin(@RequestParam String correo, @RequestParam String password, Model model) {
        
    	cliente = clienteService.validarClienteInicio(correo, password);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            
            // Redirigir a la página principal
            return "redirect:/paginaPrincipal"; 
        }
        
        return "login";
    }
    
    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String registro() {
        return "registro";
    }
    
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String procesaRegistro(@RequestParam String usuario, @RequestParam String correo, @RequestParam String contraseña, Model model) {
        if (clienteService.validarRegistro(correo)) {
            return "registro";
        }
        
        Cliente client = clienteService.nuevoCliente(usuario, correo, contraseña);
        System.out.println(client.getUsuario());
        model.addAttribute("cliente", client);
        
        return "paginaPrincipal";
    }
    
    @RequestMapping(value = "/paginaPrincipal", method = RequestMethod.GET)
    public String mostrarPaginaPrincipal(Model model) {
        // Lógica adicional si es necesario
    	
        return "paginaPrincipal"; // Asegúrate de que este nombre coincide con tu archivo de vista.
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String mostrarUsuarios(Model model) {
        try {
            List<Cliente> listaClientes = clienteService.listarClientes();
            model.addAttribute("listaClientes", listaClientes); // Agregar la lista al modelo
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al cargar la lista de usuarios.");
            return "admin";
        }
        return "admin";
    }
    
    @RequestMapping(value = "/servicios", method = RequestMethod.GET)
    public String servicioss(Model model) {
    	
        model.addAttribute("servicios", servicioService.obtenerServicios());
        return "reservas";
    }
    
    @RequestMapping(value = "/hacerReservaFinal", method = RequestMethod.POST)
    public String hacerReservaFinal(
            @RequestParam String nombreServicio,
            @RequestParam String fechaReserva,
            @RequestParam String horaReserva,
            
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
        System.out.println(cliente.getUsuario()+"formulario final");
        return "paginaPrincipal"; // Redirigir a la vista de login o a otra vista que desees
    }
}
