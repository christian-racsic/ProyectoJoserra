package org.christian.tienda_venta_servicios_deporte.mvc;

import org.christian.tienda_venta_servicios_deporte.srv.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String loginControler(){
		return "paginaPrincipal";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String ea(){
		return "login";
	}
	
	
	
}
