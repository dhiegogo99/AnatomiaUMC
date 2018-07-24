//package br.com.anatomiaumc.AnatomiaUMC.services;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSender;
//
//public class JavaMailSenderImpl {
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	     
//	    mailSender.setUsername("am.png2018@gmail.com");
//	    mailSender.setPassword("dhiegofoda");
//	     
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	     
//	    return mailSender;
//	}
//}
//
