package br.com.anatomiaumc.AnatomiaUMC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		http.authorizeRequests().antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated()
				.antMatchers("/indexAluno").hasRole("ALUNO")
				.antMatchers("/indexAdm").hasRole("ADM")
				.antMatchers("/indexProfessor").hasRole("PROFESSOR")
				.antMatchers("/insereRGM").hasRole("ADM")
				.antMatchers("/VerificaRGM").permitAll()
				.and().formLogin()
				.successHandler(customizeAuthenticationSuccessHandler)
				.loginPage("/login").permitAll().and().logout().permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}

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

}