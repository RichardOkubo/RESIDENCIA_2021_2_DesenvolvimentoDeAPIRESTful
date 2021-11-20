package org.serratec.backend.projeto3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "matricula", unique = true, nullable = false)
	private Integer matricula;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
}
