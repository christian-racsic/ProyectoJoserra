package org.christian.tienda_venta_servicios_deporte.mvc;

import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.model.Reservas;
import org.christian.tienda_venta_servicios_deporte.model.Servicio;
import org.christian.tienda_venta_servicios_deporte.srv.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

public class ServicioController {
	@Autowired
	ServicioService servicioservice;
	
	@RequestMapping(value="/logoutServ", method = RequestMethod.GET)
	public String logoutServ(Model model) {
		model.addAttribute("cliente", null);
		return "login";
	}
	
	
}
