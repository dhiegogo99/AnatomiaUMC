package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.anatomiaumc.AnatomiaUMC.models.Role;
import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;
import br.com.anatomiaumc.AnatomiaUMC.repositories.RolesRepository;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UsuarioRepository;

@Controller
public class CadastraAlunoController {
	
	@Autowired
	RolesRepository rolesrepo;
	
	
	@Autowired
	BCryptPasswordEncoder cryp;
	
	@Autowired
	UsuarioRepository ur;

	@GetMapping(value = "/cadastroAluno")
	public String CadastrarAluno(HttpSession session, Model model) {
		model.addAttribute("login", session.getAttribute("login"));
		
		return "Views/all/cadastro";
	}

	@RequestMapping(value = "/cadastroAluno")
	public String CadastroAluno(@RequestParam("nome") String nome,
			@RequestParam("email") String email,
			@RequestParam("login") String login,
			@RequestParam("senha") String senha,
			@RequestParam("confirmasenha") String confirmasenha,
			Model model, HttpSession session) throws IOException {
		
		String url = "";
		UsuarioModel Aluno = new UsuarioModel();
		Aluno = ur.findByLogin(login);
		Aluno.setNome(nome);
		Aluno.setEmail(email);
		Aluno.setLogin(login);
		
		Aluno.setSenha(cryp.encode(senha));
		Aluno.setStatus(true);
		
		
		
		if (Aluno != null) {
			if(senha.equals(confirmasenha)){
				ur.save(Aluno);
				
				url = "redirect:login";
			}else{
				model.addAttribute("login", session.getAttribute("login"));
				model.addAttribute("senhaerror",true);
				url = "Views/all/cadastro";
			}
			
		}
		return url;
	}

}
