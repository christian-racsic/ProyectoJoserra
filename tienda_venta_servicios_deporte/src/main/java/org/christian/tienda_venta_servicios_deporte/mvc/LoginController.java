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

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    Servicio servicio = null;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String procesaLogin(@RequestParam String correo, @RequestParam String password, Model model) {
        
    	cliente = clienteService.validarClienteInicio(correo, password);
       
    	
    	if(correo.equalsIgnoreCase("admin@admin.es")&& password.equalsIgnoreCase("admin")) {
    		 model.addAttribute("listaClientes", clienteService.listarClientes());
    		 return "admin";
    	}
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            
            
            return "redirect:/paginaPrincipal"; 
        }
        
        return "login";
    }
    
    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String registro(Model model) {
    	
    		model.addAttribute("cliente", new Cliente("Nombre de usuario","Contraseña","nombreUsuarios@hotamil.com"));      
    			
    		return "registro";
    
    
    
    }
    
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String procesaRegistro(Model model,@Valid Cliente clientee, BindingResult validacion) {
        String errores = "";
    	if(validacion.hasErrors()) {
    		return "registro";
    	}
        
    	
    	try {
    		if (clienteService.validarRegistro(clientee.getEmail())) {
                return "registro";
            }
            cliente = clienteService.nuevoCliente(clientee.getUsuario(), clientee.getEmail(), clientee.getPassword());
            /*cliente = clienteService.nuevoCliente(usuario, email, password);*/
            System.out.println(cliente.getUsuario());
            model.addAttribute("cliente", cliente);
            
            return "paginaPrincipal";
    	}catch(Exception e) {
    		errores = e.toString();
    	}
    	model.addAttribute("errores", errores);
    	return "registro";
    	
    }
    
    @RequestMapping(value = "/paginaPrincipal", method = RequestMethod.GET)
    public String mostrarPaginaPrincipal(Model model) {
       
    	
        return "paginaPrincipal"; 
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
            Reservas reservaa,  // Captura el objeto completo
            @ModelAttribute("cliente") Cliente cliente,  // Asegúrate de tener el cliente disponible
            Model model) {

          // Obtén el servicio de la reserva
        if (servicio == null) {
            model.addAttribute("error", "El servicio no se encontró.");
            return "error"; // Redirigir a una vista de error si es necesario
        }

        LocalDate fecha = reservaa.getFecha();
        LocalTime tiempo = reservaa.getTiempo();
        Reservas reserve = new Reservas (fecha,tiempo,servicio,cliente);
        
        
        reservaService.guardarReserva(reserve, cliente);

        model.addAttribute("mensaje", "Reserva confirmada para el servicio: " + reserve.getServicio().getNombre());
        model.addAttribute("cliente", cliente);

        System.out.println(cliente.getUsuario() + " formulario final");
        return "paginaPrincipal"; 
    }
    
    @RequestMapping(value="/paginaPrincipalServ", method = RequestMethod.GET)
	public String irPaginaPrincipal(Model model) {
		model.addAttribute("cliente", cliente);
		
	    return "paginaPrincipal";
	}
    
    @RequestMapping(value="/hacerReserva", method = RequestMethod.GET)
	public String hacerReserva(@RequestParam("nombreServicio") String nombreServicio,
	                            @ModelAttribute("cliente") Cliente cliente,
	                            Model model) {
	    model.addAttribute("cliente", cliente);
	    servicio = servicioService.obtenerServicioporNombre(nombreServicio);
	    Reservas reserva = new Reservas();
	    /*model.addAttribute("servicio", servicio);*/
	    model.addAttribute("reservas", reserva); 
	    return "formularioReserva";
	}
}
