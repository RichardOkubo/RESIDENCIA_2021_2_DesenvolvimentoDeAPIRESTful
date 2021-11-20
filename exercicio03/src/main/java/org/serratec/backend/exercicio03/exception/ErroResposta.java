package org.serratec.backend.exercicio03.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroResposta {
	
	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private List<String> erros;
}
