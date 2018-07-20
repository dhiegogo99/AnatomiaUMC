package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	
	@GetMapping("/")
	public String mapeamentoBarra(){
		return "Views/all/login";
	}
	@GetMapping("/login")
	public String login(){
		return "Views/all/login";
	}
	
	
	
	
	@GetMapping("/novaSenha")
	public String novaSenha(){
		return "Views/all/resetSenha";
	}
	
		

		
	
	@GetMapping("/index")
	public String index(){
		return "Views/index";
	}
	
	@GetMapping("/register")
	public String register(){
		return "Views/register";
	}
	
	public String RedirecionaLogin(){
		return null;
		
	}
}
