package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoController {

	@GetMapping("/indexAluno")
	public String indexAluno(){
		return "Views/aluno/indexAluno";
	}
	
}
