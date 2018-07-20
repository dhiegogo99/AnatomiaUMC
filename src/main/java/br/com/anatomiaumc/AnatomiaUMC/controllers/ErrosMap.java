package br.com.anatomiaumc.AnatomiaUMC.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;



	@Controller
	public class ErrosMap {

//	    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//	    @ExceptionHandler(Exception.class)
	    @RequestMapping(value = "/erros")
	    public ModelAndView tratadorDeException() {

	        ModelAndView modelAndView = new ModelAndView();
	        //
	        modelAndView.setViewName("Views/erros/erro");

	        return modelAndView;
	    
	}
	    
	    
	    @RequestMapping(value = "/errologado")
	    public ModelAndView errologado() {

	        ModelAndView modelAndView = new ModelAndView();
	        //
	        modelAndView.setViewName("Views/erros/naoestarlogado");

	        return modelAndView;
	    
	}
	
}
