package org.christian.tienda_venta_servicios_deporte.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	@Autowired
	ClienteService clienteService;
	
	
}
