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
public class UserRegister {

	@Autowired
	BCryptPasswordEncoder cryp;

	@Autowired
	UserRepository ur;

	@GetMapping(value = "/RegisterStudent")
	public String RegisterStudent(HttpSession session, Model model) {
		model.addAttribute("login", session.getAttribute("login"));
		return "Views/all/Register";
	}

	@RequestMapping(value = "/RegisterStudent")
	public String CadastroAluno(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("login") String login,
			@RequestParam("password") String password,
			@RequestParam("confirmpassword") String confirmpassword,
			Model model, HttpSession session) throws IOException {

		Optional<User> userValidate = ur.findUserByEmail(email);

		String url = "";
		if (!userValidate.isPresent()) {
			User user = new User();
			user = ur.findByLogin(login);
			user.setName(name);
			user.setEmail(email);
			user.setLogin(login);
			user.setPassword(cryp.encode(password));
			user.setStatus(true);
			if (user != null) {
				if (password.equals(confirmpassword)) {
					ur.save(user);
					model.addAttribute("registrationSucces", true);
					url = "Views/all/login";
				} else {
					model.addAttribute("login", session.getAttribute("login"));
					model.addAttribute("passwordError", true);
					url = "Views/all/Register";
				}

			}
		}
		else{
			model.addAttribute("login", session.getAttribute("login"));
			model.addAttribute("EmailAlreadyExists", true);
			url = "Views/all/Register";
		}
		return url;
	}
	
	@GetMapping("/LoginValidate")
	public String LoginValidate() {
		return "Views/all/LoginValidate";
	}
	@RequestMapping(value="/LoginValidate")
	public String LoginValidate(@RequestParam("login") String login, Model model, HttpSession session) throws IOException {
		String url = "";
		User user = ur.findByLogin(login);
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
