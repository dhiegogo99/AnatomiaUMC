package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdmController {

	@GetMapping("/indexAdm")
	public String indexAdm(){
		return "Views/admin/indexAdm";
	}
	
}
