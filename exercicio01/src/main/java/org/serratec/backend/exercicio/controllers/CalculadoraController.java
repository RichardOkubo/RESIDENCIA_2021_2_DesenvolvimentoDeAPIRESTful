package org.serratec.backend.exercicio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculadora")
public class CalculadoraController {

	@GetMapping("/somar")
	public int somar(@RequestParam int x, @RequestParam int y) {
		return x + y;
	}
	
	@GetMapping("/subtrair")
	public int subtrair(@RequestParam int x, @RequestParam int y) {
		return x - y;
	}
	
	@GetMapping("/multiplicar")
	public int multiplicar(@RequestParam int x, @RequestParam int y) {
		return x * y;
	}
	
	@GetMapping("/dividir")
	public double dividir(@RequestParam double x, @RequestParam double y) {
		return (y != 0) ? x/y : 0;
	}
}
