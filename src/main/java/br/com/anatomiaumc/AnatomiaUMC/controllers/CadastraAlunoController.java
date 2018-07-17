package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.anatomiaumc.AnatomiaUMC.models.CursoModel;
import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UsuarioRepository;

@Controller
public class CadastraAlunoController {
	@Autowired
	BCryptPasswordEncoder cryp;
	
	@Autowired
	UsuarioRepository ur;

	@GetMapping(value = "/cadastroAluno")
	public String CadastrarAluno() {
		return "Views/cadastro";
	}

	@RequestMapping(value = "/cadastroAluno")
	public String CadastroAluno(@RequestParam("nome") String nome,
			@RequestParam("email") String email,
			@RequestParam("login") String login,
			@RequestParam("senha") String senha,
			
		
			Model model) throws IOException {
		String url = "";
		UsuarioModel Aluno = new UsuarioModel();
		Aluno = ur.findByLogin(login);
		Aluno.setNome(nome);
		Aluno.setEmail(email);
		Aluno.setLogin(login);
		senha = cryp.encode(senha);
		Aluno.setSenha(senha);
		Aluno.setStatus(true);
		
		
		if (Aluno != null) {
			
			ur.save(Aluno);
			
			url = "redirect:login";
		}
		return url;
	}

}
