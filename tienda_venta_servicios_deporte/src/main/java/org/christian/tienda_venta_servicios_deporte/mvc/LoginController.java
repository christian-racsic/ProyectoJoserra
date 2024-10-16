package org.christian.tienda_venta_servicios_deporte.mvc;

import java.util.List;

import org.christian.tienda_venta_servicios_deporte.dto.ClienteDTO;
import org.christian.tienda_venta_servicios_deporte.mapper.ClienteMapper;
import org.christian.tienda_venta_servicios_deporte.model.Cliente;
import org.christian.tienda_venta_servicios_deporte.srv.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
@Controller
public class LoginController {
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginControler(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String procesaLogin(@RequestParam String correo, @RequestParam String password,Model model){
		 Cliente cliente = clienteService.validarClienteInicio(correo, password);
		 //Cliente clienteAdmin = clienteService.validarAdmin(correo, password);
		 
		 /*if(clienteAdmin!=null) {
			 ClienteDTO clienteDTO = ClienteMapper.INSTANCE.clienteToClienteDTO(cliente);
				model.addAttribute("cliente", clienteDTO);
				List <Cliente> clientees = clienteService.listarClientes();
				model.addAttribute("listaClientes", clientees );
				return "paginaPrincipal";
		 }*/
		 
		 if(cliente!=null) {
			ClienteDTO clienteDTO = ClienteMapper.INSTANCE.clienteToClienteDTO(cliente);
			model.addAttribute("cliente", clienteDTO);
			return "paginaPrincipal";
		}
			return "login";
		
		
		
		
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registro(){
		return "registro";
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String procesaRegistro(@RequestParam String usuario,@RequestParam String correo,@RequestParam String contraseña,Model model){
		if(clienteService.validarRegistro(correo)) {
			
			
			return "registro";
		}
		
		Cliente client = clienteService.nuevoCliente(usuario, correo, contraseña);
		model.addAttribute("cliente", client);
		
		return "paginaPrincipal";
		
		
		
		
	}
	
	
	
	
}
