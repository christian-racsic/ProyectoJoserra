package org.christian.tienda_venta_servicios_deporte.mvc;

import java.util.List;

import org.christian.tienda_venta_servicios_deporte.dto.ClienteDTO;
import org.christian.tienda_venta_servicios_deporte.mapper.ClienteMapper;
import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.srv.ClienteService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginControler() {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String procesaLogin(@RequestParam String correo, @RequestParam String password, Model model) {
        Cliente cliente = clienteService.validarClienteInicio(correo, password);
        
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
}
