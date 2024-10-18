package org.christian.tienda_venta_servicios_deporte.mvc;

import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.model.Servicio;
import org.christian.tienda_venta_servicios_deporte.srv.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServicioController {
	@Autowired
	ServicioService servicioservice;
	
	@RequestMapping(value="/paginaPrincipalServ", method = RequestMethod.GET)
	public String irPaginaPrincipal(@ModelAttribute("cliente") Cliente cliente,Model model) {
		model.addAttribute("cliente", cliente);
		model.addAttribute("reservas", cliente.getReservas());
	    return "paginaPrincipal";
	}
	
	@RequestMapping(value="/logoutServ", method = RequestMethod.GET)
	public String logoutServ(Model model) {
		model.addAttribute("cliente", null);
		return "login";
	}
	
	@RequestMapping(value="/hacerReserva", method = RequestMethod.GET)
	public String hacerReserva(@RequestParam("nombreServicio") String nombreServicio,@ModelAttribute("cliente") Cliente cliente,Model model) {
		model.addAttribute("cliente", cliente);
		Servicio servicio = servicioservice.obtenerServicioporNombre(nombreServicio);
		model.addAttribute("servicio", servicio);
		return "formularioReserva";
		
	}
}
