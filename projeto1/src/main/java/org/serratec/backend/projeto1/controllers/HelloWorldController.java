package org.serratec.backend.projeto1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, world!";
	}
	
	@GetMapping("/hi")
	public String sayHi(@RequestParam("name") String nome) {
		return "Hi, " + nome + "!";
	}
}
