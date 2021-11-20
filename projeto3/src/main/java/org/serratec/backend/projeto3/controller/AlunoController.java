package org.serratec.backend.projeto3.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto3.domain.Aluno;
import org.serratec.backend.projeto3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> pesquisarPorId(@PathVariable Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno inserir(@RequestBody Aluno aluno){
		alunoRepository.save(aluno);
		return aluno;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizarPeloId(@PathVariable Integer id, @RequestBody Aluno aluno){
		Optional<Aluno> aluno1 = alunoRepository.findById(id);
			if(aluno1.isPresent()) {
			if(null != aluno.getTelefone()) {
				aluno1.get().setTelefone(aluno.getTelefone());
			}
			if(null !=aluno.getMatricula()) {
				aluno1.get().setMatricula(aluno.getMatricula());
			}
			if(null !=aluno.getNome()) {
				aluno1.get().setNome(aluno.getNome());
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(alunoRepository.save(aluno1.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		if(!alunoRepository.existsById(id)) {			
			return ResponseEntity.notFound().build();
		}
		alunoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
