package org.serratec.backend.h2banco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Veiculo;
import org.serratec.backend.h2banco.repository.VeiculoRepository;
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
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public List<Veiculo> listar() {
		return veiculoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(veiculo.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@Valid @RequestBody Veiculo veiculo){
		return veiculoRepository.save(veiculo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizarPeloId(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo){
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
		
			if (veiculoOptional.isPresent()) {
				if (null != veiculo.getPlaca()) veiculoOptional.get().setPlaca(veiculo.getPlaca());
				if (null != veiculo.getMarca()) veiculoOptional.get().setMarca(veiculo.getMarca());
				if (null != veiculo.getModelo()) veiculoOptional.get().setModelo(veiculo.getModelo());
				if (null != veiculo.getCaracteristica()) veiculoOptional.get().setCaracteristica(veiculo.getCaracteristica());
			}
			else {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(veiculoRepository.save(veiculoOptional.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!veiculoRepository.existsById(id)) {			
			return ResponseEntity.notFound().build();
		}
		veiculoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
