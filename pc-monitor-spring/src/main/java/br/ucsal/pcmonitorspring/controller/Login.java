package br.ucsal.pcmonitorspring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("qualquercoisa");
		return "novo";
	}
}
