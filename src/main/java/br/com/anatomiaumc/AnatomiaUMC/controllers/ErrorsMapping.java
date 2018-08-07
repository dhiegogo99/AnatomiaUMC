package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



	@Controller
	public class ErrorsMapping {

//	    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//	    @ExceptionHandler(Exception.class)
	    @RequestMapping(value = "/errors")
	    public ModelAndView Error() {

	        ModelAndView modelAndView = new ModelAndView();
	        //
	        modelAndView.setViewName("Views/errors/error");

	        return modelAndView;
	    
	}
	    
	    
	    @RequestMapping(value = "/notLogged")
	    public ModelAndView errorNotLogged() {

	        ModelAndView modelAndView = new ModelAndView();
	        //
	        modelAndView.setViewName("Views/errors/notLogged");

	        return modelAndView;
	    
	}
	
}
