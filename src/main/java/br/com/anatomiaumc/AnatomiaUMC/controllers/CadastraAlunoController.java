package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastraAlunoController {
	
//	@GetMapping("/CadastroAluno")
	public String CadastrarAluno() {
		return "Views/cadastro";
	}
	
}
