package org.serratec.backend.projeto3;

import org.serratec.backend.projeto3.model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projeto3Application implements CommandLineRunner {
	
	@Autowired
	private Pagamento pagamento;

	public static void main(String[] args) {
		SpringApplication.run(Projeto3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Total a pagar: " + pagamento.calcularProcedimentos(200., 80.));
	}

}
