package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.anatomiaumc.AnatomiaUMC.models.User;
import br.com.anatomiaumc.AnatomiaUMC.services.EmailServiceImpl;
import br.com.anatomiaumc.AnatomiaUMC.services.UserServiceImpl;

@Controller
public class ForgotPassword {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private EmailServiceImpl emailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Display forgotPassword page
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String displayForgotPasswordPage() {
		return "Views/all/forgot";
	}

	// Process form submission from forgotPassword page
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String processForgotPasswordForm(
			@RequestParam("email") String userEmail,
			HttpServletRequest request, Model model) {

		// Lookup user in database by e-mail
		Optional<User> optional = userService
				.findUserByEmail(userEmail);

		if (!optional.isPresent()) {
			model.addAttribute("emailNotFound", true);
		} else {

			// Generate random 36-character string token for reset password
			User user = optional.get();
			user.setResetToken(UUID.randomUUID().toString());

			// Save token to database
			userService.save(user);

			String appUrl = request.getScheme() + "://"
					+ request.getServerName();

			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("am.png@gmail.com");

			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Nova Senha");
			passwordResetEmail.setText("Ola " + user.getName()
					+ "./nClique aki para gerar sua nova senha caralhuda\n"
					+ appUrl + ":9006/reset?token=" + user.getResetToken());

			emailService.sendEmail(passwordResetEmail);

			// Add success message to view
			model.addAttribute("forgot", true);
		}

		return "Views/all/forgot";

	}

	// Display form to reset password
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String displayResetPasswordPage(Model model,
			@RequestParam("token") String token) {

		Optional<User> user = userService.findUserByResetToken(token);

		if (user.isPresent()) { // Token found in DB
			model.addAttribute("resetToken", token);
			model.addAttribute("errortoken", false);
		} else { // Token not found in DB
			model.addAttribute("errortoken", true);
		}

		return "Views/all/ResetPassword";
	}

	// Process reset password form
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String setNewPassword(Model model,
			@RequestParam Map<String, String> requestParams,
			RedirectAttributes redir, HttpServletRequest request) {
		String aux = "";

		// Find the user associated with the reset token
		Optional<User> user = userService
				.findUserByResetToken(requestParams.get("token").toString());

		// This should always be non-null but we check just in case
		if (user.isPresent()) {

			User resetUser = user.get();

			// Set new password
			resetUser.setPassword(bCryptPasswordEncoder.encode(requestParams
					.get("password")));

			// Set the reset token to null so it cannot be used again
			resetUser.setResetToken(null);

			// Save user
			userService.save(resetUser);

			// In order to set a model attribute on a redirect, we must use
			// RedirectAttributes
			redir.addFlashAttribute("successMessage",
					"You have successfully reset your password.  You may now login.");
			model.addAttribute("successReset", true);
			aux = "Views/all/login";

		} else {
			model.addAttribute("errortoken", true);
			aux = "Views/all/ResetPassword";
		}

		return aux;
	}

	// Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(
			MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}
}