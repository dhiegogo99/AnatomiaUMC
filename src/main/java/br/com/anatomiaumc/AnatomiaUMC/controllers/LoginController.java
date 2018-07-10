package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.anatomiaumc.AnatomiaUMC.controllers.*;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(){
		return "Views/login";
	}
	
	@GetMapping("/novaSenha")
	public String novaSenha(){
		return "Views/resetSenha";
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
