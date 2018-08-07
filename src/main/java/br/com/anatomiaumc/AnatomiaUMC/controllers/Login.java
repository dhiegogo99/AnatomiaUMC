package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

	@GetMapping("/")
	public String mapeamentoBarra() {
		return "Views/all/login";
	}

	@GetMapping("/login")
	public String login() {
		return "Views/all/login";
	}
}
