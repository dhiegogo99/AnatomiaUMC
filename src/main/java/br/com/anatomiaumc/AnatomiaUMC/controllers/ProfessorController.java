package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {

	@GetMapping("/indexProfessor")
	public String indexProfessor(){
		return "Views/indexProf";
	}
	
}
