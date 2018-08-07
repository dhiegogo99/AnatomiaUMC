package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.anatomiaumc.AnatomiaUMC.models.User;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UserRepository;

@Controller
public class LoginValidate {

	@Autowired
	UserRepository rr;

	@GetMapping("/LoginValidate")
	public String LoginValidate() {
		return "Views/all/LoginValidate";
	}
	@RequestMapping(value="/LoginValidate")
	public String LoginValidate(@RequestParam("login") String login, Model model, HttpSession session) throws IOException {
		String url = "";
		User user = rr.findByLogin(login);
		if (((user)!= null) && !user.getStatus()) {
			model.addAttribute("id",login);
			session.setAttribute("login", user.getLogin());
			url=  "redirect:/RegisterStudent";
		} else if (user == null){
			model.addAttribute("error",true);
			url= "Views/all/LoginValidate";
		}else if(user.getStatus()){
			model.addAttribute("exist",true);
			url= "Views/all/LoginValidate";
		}
		return url;
	}
}
