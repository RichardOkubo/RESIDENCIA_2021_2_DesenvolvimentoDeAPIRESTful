package org.serratec.backend.exercicio.veiculo.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.exercicio.veiculo.domain.Veiculo;
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
@RequestMapping("/veiculos")
public class VeiculoController {
	
	private static List<Veiculo> listaDeVeiculos = new ArrayList<>();

	static {
		listaDeVeiculos.add(new Veiculo(1L, "CHEVROLET", "CHEVROLET CLASSIC"));
		listaDeVeiculos.add(new Veiculo(2L, "FIAT", "FIAT UNO"));
		listaDeVeiculos.add(new Veiculo(3L, "VOLKSWAGEN", "VOLKSWAGEN FOX"));
		listaDeVeiculos.add(new Veiculo(4L, "FORD", "FORD ECOSPORT"));
		listaDeVeiculos.add(new Veiculo(5L, "RENAULT", "RENAULT KWID"));
		listaDeVeiculos.add(new Veiculo(6L, "HYUNDAI", "HYUNDAI HB20"));
		listaDeVeiculos.add(new Veiculo(7L, "TOYOTA", "TOYOTA HILUX"));
		listaDeVeiculos.add(new Veiculo(8L, "HONDA", "HONDA FIT"));
	}

	@GetMapping
	public List<Veiculo> listar() {
		return listaDeVeiculos;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
		return listaDeVeiculos.stream()
				.filter(veiculo -> veiculo.getId().equals(id))
				.findFirst()
				.orElse(null);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@RequestBody Veiculo veiculo) {
		listaDeVeiculos.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		for (Veiculo veiculo : listaDeVeiculos) {
			if (veiculo.getId().equals(id)) {
				listaDeVeiculos.remove(veiculo);
				return;
			}	
		}
		//listaDeVeiculos.removeIf(veiculo -> veiculo.getId().equals(id));
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo novoVeiculo, @PathVariable Long id) {
		for (int i = 0; i < listaDeVeiculos.size(); i++) {
			if (listaDeVeiculos.get(i).getId().equals(id)) {
				listaDeVeiculos.set(i, new Veiculo(novoVeiculo.getId(), novoVeiculo.getMarca(), novoVeiculo.getModelo()));
				return novoVeiculo;
			}
		}
		return null;
	}

}
