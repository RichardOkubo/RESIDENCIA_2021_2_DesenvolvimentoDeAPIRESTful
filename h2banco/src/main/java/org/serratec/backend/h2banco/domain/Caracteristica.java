package org.serratec.backend.h2banco.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caracteristica {

	private String renavam;
	private String chassi;
	private Long ano;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private String cor;
	
	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;
}
