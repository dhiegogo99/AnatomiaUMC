package br.com.anatomiaumc.AnatomiaUMC.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);
        
        boolean admin = false;
        boolean prof = false;
        boolean aluno = false;
        logger.info("AT onAuthenticationSuccess(...) function!");
        
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ALUNO".equals(auth.getAuthority())){
            	admin = false;
            	prof = false;
            	aluno = true;
            }else if("PROFESSOR".equals(auth.getAuthority())){
            	admin = false;
            	prof = true;
            	aluno = false;
            }else if("ADM".equals(auth.getAuthority())){
            	admin = true;
            	prof = false;
            	aluno = false;
            }
        }
        
        if(admin){
        	response.sendRedirect("/indexAdm");
        }else if (aluno){
        	response.sendRedirect("/indexAluno");
        }else if(prof){
        	response.sendRedirect("/indexProfessor");

        }
	}
}