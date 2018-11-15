package br.com.anatomiaumc.AnatomiaUMC.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConteudoController {

	@GetMapping("/import")
	public String indexAdm(HttpSession session, Model model){
	
		
		model.addAttribute("user",session.getAttribute("logado"));
		return "Views/all/import";
	}
	
}
