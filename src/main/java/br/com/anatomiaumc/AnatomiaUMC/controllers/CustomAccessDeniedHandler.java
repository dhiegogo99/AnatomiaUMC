package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
 
   
 
    @Override
    public void handle(
      HttpServletRequest request,
      HttpServletResponse response, 
      AccessDeniedException exc) throws IOException, ServletException {
         
        Authentication auth 
          = SecurityContextHolder.getContext().getAuthentication();
       
        if(request.getRequestURI().equals(request.getContextPath() + "/LoginValidate")&& auth!= null){
        	response.sendRedirect(request.getContextPath() + "/notLogged");
        }  
  
        else
        	
        	if(request.getRequestURI().equals(request.getContextPath() + "/RegisterStudent")&& auth!= null){
            	response.sendRedirect(request.getContextPath() + "/notLogged");
            }  
      
            else
        	
        	if (request.getRequestURI().equals(request.getContextPath() + "/LoginValidate")&& auth == null){
        
        response.sendRedirect(request.getContextPath() + "/LoginValidate");
    }else{
    	response.sendRedirect(request.getContextPath() + "/errors");
    }
        
        }
}