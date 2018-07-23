package br.com.anatomiaumc.AnatomiaUMC.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.anatomiaumc.AnatomiaUMC.repositories.UsuarioRepository;

@Controller
public class AlunoController {
	UsuarioRepository usuario;
	@GetMapping("/indexAluno")
	public String indexAluno(HttpSession session, Model model){
	
		
		model.addAttribute("user",session.getAttribute("logado"));
	
		return "Views/aluno/indexAluno";
	}
	
}
