package org.serratec.backend.projeto3.model;

import org.springframework.stereotype.Component;

@Component
public class Exame {

	public Double calcularExame(Double valorExame) {
		return valorExame * 0.3;
	}

}
