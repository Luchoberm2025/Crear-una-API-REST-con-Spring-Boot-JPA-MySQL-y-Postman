package com.SENA.API.sistema.edicativo.integral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del sistema educativo integral.
 * Esta clase inicia la aplicación Spring Boot, configura el contexto de la aplicación
 * y pone en marcha todos los componentes necesarios.
 */
@SpringBootApplication
public class SistemaEdicativoIntegralApplication {

	/**
	 * Método principal de la aplicación.
	 * Este método es el punto de entrada del sistema. Utiliza SpringApplication.run para arrancar la aplicación.
	 *
	 * @param args Argumentos de línea de comandos que se pueden pasar al iniciar la aplicación.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SistemaEdicativoIntegralApplication.class, args);
	}

}
