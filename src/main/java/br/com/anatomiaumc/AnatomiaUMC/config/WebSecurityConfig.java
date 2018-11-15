package br.com.anatomiaumc.AnatomiaUMC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import br.com.anatomiaumc.AnatomiaUMC.controllers.CustomAccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/all/**").permitAll()
				.antMatchers("/VerificaRGM").not().authenticated()
				.antMatchers("/login").not().authenticated()
				.antMatchers("/cadastroAluno").not().authenticated()
				
				
				//aluno
				.antMatchers("/indexAluno").hasAuthority("ALUNO")
				
				
				
				//professor
				.antMatchers("/indexProfessor").hasAuthority("PROFESSOR")
				
				
				
				//adm
				.antMatchers("/indexAdm").hasAuthority("ADM")
				.antMatchers("/insereRGM").hasAuthority("ADM")
				
				
				
				.and()
				
			.formLogin()
					.successHandler(customizeAuthenticationSuccessHandler)
					.loginPage("/login").permitAll()
				.and()
				
			.logout()
				.permitAll();
		
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		
//				.anyRequest().authenticated()
//		
//				.antMatchers("/resources/**").permitAll()
//				.antMatchers("/VerificaRGM").permitAll()
//				.antMatchers("/indexAluno").access("hasRole('ALUNO')")
//				.antMatchers("/indexAdm").access("hasRole('ADM')")
//				.antMatchers("/indexProfessor").access("hasRole('PROFESSOR')")
//				.antMatchers("/insereRGM").access("hasRole('ADM')")
//				
//				.and()
//				
//			.formLogin()
//					.successHandler(customizeAuthenticationSuccessHandler)
//					.loginPage("/login").permitAll()
//				.and()
//				
//			.logout()
//				.permitAll();
//		
//		http.exceptionHandling().accessDeniedPage("/403");
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		super.configure(auth);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
	    return new CustomAccessDeniedHandler();
	}

}