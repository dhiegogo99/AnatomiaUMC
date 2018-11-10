package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.anatomiaumc.AnatomiaUMC.models.User;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UserRepository;

@Controller
public class AlterUser {

	@Autowired
	BCryptPasswordEncoder cryp;

	@Autowired
	UserRepository ur;

	@RequestMapping(value = "/AlterUser")
	public String AterUser(Model model, HttpSession session) throws IOException {
		String login = ((User) session.getAttribute("logged")).getLogin();
		String url = "";
		User user = ur.findByLogin(login);
		model.addAttribute("id", login);
		session.setAttribute("login", user.getLogin());

		url = "Views/all/registryModification";

		return url;
	}

	@RequestMapping(value = "/ExecAlterUser")
	public String ExecuteAterUser(Model model, HttpSession session, @RequestParam("email") String email,
			@RequestParam("login") String login, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("confirmpassword") String confirmpassword)
			throws IOException {
		User user = ur.findByLogin(login);
		if(password.equals(confirmpassword)) {
			user.setEmail(email);
			user.setName(name);
			user.setPassword(cryp.encode(password));
			ur.save(user);
			model.addAttribute("SucessaAlterUser", true);
		}else{
			model.addAttribute("AlterUserErrorPassword", true);
		}
		session.setAttribute("logged", user);
		model.addAttribute("id",login);	
		return "Views/all/registryModification";
	}

}
