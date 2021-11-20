package org.serratec.backend.h2banco.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Preencha a placa")
	@Size(max = 7)
	@Column(nullable = false, length = 7)
	private String placa;
	
	@NotBlank(message = "Preencha a marca")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String marca;
	
	@NotBlank(message = "Preencha a modelo")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	private String modelo;
	
	@Embedded
	private Caracteristica caracteristica;
}
