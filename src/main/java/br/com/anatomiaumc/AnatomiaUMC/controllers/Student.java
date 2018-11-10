package br.com.anatomiaumc.AnatomiaUMC.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Student {
	@GetMapping("/indexStudent")
	public String indexStudent(HttpSession session, Model model){
	
		
		model.addAttribute("user",session.getAttribute("logged"));
	
		return "Views/students/indexStudent";
	}
	

	
}
