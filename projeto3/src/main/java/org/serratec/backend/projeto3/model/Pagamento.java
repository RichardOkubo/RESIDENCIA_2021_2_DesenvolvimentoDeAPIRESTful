package org.serratec.backend.projeto3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pagamento {
	
	@Autowired
	private Consulta consulta;
	
	@Autowired
	private Exame exame;

	public Double calcularProcedimentos(Double valorConsulta, Double valorExame) {
		return consulta.calcularConsulta(valorConsulta)
				+ exame.calcularExame(valorExame);
	}

}
