package br.com.anatomiaumc.AnatomiaUMC.services;

import org.springframework.mail.SimpleMailMessage;


public interface EmailService {
	public void sendEmail(SimpleMailMessage email);
}