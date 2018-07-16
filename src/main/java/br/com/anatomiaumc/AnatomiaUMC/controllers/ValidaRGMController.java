package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.anatomiaumc.AnatomiaUMC.models.RgmModel;
import br.com.anatomiaumc.AnatomiaUMC.repositories.RgmRepository;

@Controller
public class ValidaRGMController {

	@Autowired
	RgmRepository rr;

	@GetMapping("/VerificaRGM")
	public String VerificaRGM() {
		return "Views/ValidaRGM";
	}

//	@GetMapping("/goToViewPage")
	public ModelAndView passParametersWithModelAndView() {
		ModelAndView modelAndView = new ModelAndView("CadastroAluno");
		return modelAndView;
	}

	@RequestMapping(value="/VerificaRGM")
	public String ValidaRGM(@RequestParam("RGM") String RGM, Model model) throws IOException {
		String url = "";
		RgmModel Resp = rr.findByRGM(RGM);
		
		if ((Resp)!= null) {

			url=  "Views/cadastro";
		} else {
			model.addAttribute("error",true);
			url= "Views/ValidaRGM";

		}
		ModelAndView modelAndView = new ModelAndView(url);
		return url;
	}
	
	@GetMapping(value="/cadastroAluno")
	public String CadastrarAluno() {
		return "Views/cadastro";
	}
	

}
