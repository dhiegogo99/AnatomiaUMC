package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UsuarioRepository;

@Controller
public class ValidaRGMController {

	@Autowired
	UsuarioRepository rr;

	@GetMapping("/VerificaLogin")
	public String VerificaRGM() {
		return "Views/all/ValidaRGM";
	}

//	@GetMapping("/goToViewPage")
	public ModelAndView passParametersWithModelAndView() {
		ModelAndView modelAndView = new ModelAndView("CadastroAluno");
		return modelAndView;
	}

	@RequestMapping(value="/VerificaLogin")
	public String ValidaRGM(@RequestParam("login") String login, Model model, HttpSession session) throws IOException {
		String url = "";
		UsuarioModel Resp = rr.findByLogin(login);
		
		if (((Resp)!= null) && !Resp.getStatus()) {
			model.addAttribute("id",login);
			session.setAttribute("login", Resp.getLogin());
			url=  "redirect:/cadastroAluno";
		} else if (Resp == null){
			model.addAttribute("error",true);
			url= "Views/all/ValidaRGM";
		}else if(Resp.getStatus()){
			model.addAttribute("existe",true);
			url= "Views/all/ValidaRGM";
		}
		return url;
	}
	
	
	

}
