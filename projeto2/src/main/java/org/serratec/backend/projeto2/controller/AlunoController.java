package org.serratec.backend.projeto2.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto2.domain.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private static List<Aluno> listaDeAlunos = new ArrayList<>();

	static {
		listaDeAlunos.add(new Aluno(2453L, "Carla", "2242-4242"));
		listaDeAlunos.add(new Aluno(2454L, "Yuri", "2242-4242"));
		listaDeAlunos.add(new Aluno(2455L, "Ana", "2242-4242"));
	}

	@GetMapping
	public List<Aluno> listar() {
		return listaDeAlunos;
	}

	@GetMapping("/{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {
		return listaDeAlunos.stream()
				.filter(aluno -> aluno.getMatricula().equals(matricula))
				.findFirst()
				.orElse(null);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno inserir(@RequestBody Aluno aluno) {
		listaDeAlunos.add(aluno);
		return aluno;
	}
	
	@DeleteMapping("/{matricula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long matricula) {
		for (Aluno aluno : listaDeAlunos) {
			if (aluno.getMatricula().equals(matricula)) {
				listaDeAlunos.remove(aluno);
				return;
			}	
		}
		//listaDeAlunos.removeIf(aluno -> aluno.getMatricula().equals(matricula));
	}
	
	@PutMapping("/{matricula}")
	public Aluno atualizar(@RequestBody Aluno novoAluno, @PathVariable Long matricula) {
		for (int i = 0; i < listaDeAlunos.size(); i++) {
			if (listaDeAlunos.get(i).getMatricula().equals(matricula)) {
				listaDeAlunos.set(i, new Aluno(novoAluno.getMatricula(), novoAluno.getNome(), novoAluno.getTelefone()));
				return novoAluno;
			}
		}
		return null;
	}
	
}
