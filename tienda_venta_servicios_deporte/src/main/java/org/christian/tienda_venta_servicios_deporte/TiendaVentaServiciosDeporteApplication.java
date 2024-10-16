package org.christian.tienda_venta_servicios_deporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages="org.christian")
@SpringBootApplication
public class TiendaVentaServiciosDeporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaVentaServiciosDeporteApplication.class, args);
	}

}
