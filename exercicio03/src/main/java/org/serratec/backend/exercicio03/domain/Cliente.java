package org.serratec.backend.exercicio03.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor	
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@NotBlank
	@Size(max = 60, message = "Tamanho máximo: 60 caracteres")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
	
	@NotBlank
	@CPF(message = "CPF inválido")
	@Size(max = 11, message = "Tamanho máximo: 11 caracteres")
	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@NotBlank
	@Email(message = "Email inválido")
	@Size(max = 50, message = "Tamanho máximo: 50 caracteres")
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@NotNull
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
}
