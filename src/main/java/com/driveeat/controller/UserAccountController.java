package com.driveeat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.driveeat.entity.ConfirmationToken;
import com.driveeat.entity.Users;
import com.driveeat.repository.ConfirmationTokenRepository;
import com.driveeat.repository.UsersRepository;
import com.driveeat.service.EmailSenderService;

@Controller
public class UserAccountController {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	// https://stackabuse.com/password-encoding-with-spring-security/
	// to encode our password
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	// Registration
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public ModelAndView displayRegistration(ModelAndView modelAndView, Users users) {
		modelAndView.addObject("users", users);
		modelAndView.setViewName("registration_form");
		return modelAndView;
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView modelAndView, @Valid Users users, BindingResult result) {

		Users existingUsers = usersRepository.findByEmailIgnoreCase(users.getEmail());
		if (result.hasErrors()) {
			modelAndView.addObject("hasErrors", true);
			modelAndView.addObject("users", users);
			modelAndView.setViewName("registration_form");

		} else {
			if (existingUsers != null) {
				modelAndView.addObject("message", "Cet email est déjà utilisé, merci d'en saisir un nouveau !");
				modelAndView.setViewName("registration_form");
			} else {
				users.setPassword(encoder.encode(users.getPassword()));
				usersRepository.save(users);

				ConfirmationToken confirmationToken = new ConfirmationToken(users);

				confirmationTokenRepository.save(confirmationToken);

				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(users.getEmail());
				mailMessage.setSubject("Confirmer votre inscription !");
				mailMessage.setFrom("contact.driveat@gmail.com");
				mailMessage.setText("Pour finaliser votre inscription, cliquez sur ce lien : "
						+ "http://localhost:8080/confirm-compte?token=" + confirmationToken.getConfirmationToken());

				emailSenderService.sendEmail(mailMessage);

				modelAndView.addObject("email", users.getEmail());

				modelAndView.setViewName("successfulRegisteration");
			}
		}

		return modelAndView;
	}

	// Confirm registration
	@RequestMapping(value = "/confirm-compte", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			Users users = usersRepository.findByEmailIgnoreCase(token.getUsers().getEmail());
			users.setEnabled(true);
			usersRepository.save(users);
			modelAndView.addObject("message", "Votre compte a été activé. Vous pouvez maintenant vous connecter");
			modelAndView.setViewName("accountVerified");
		} else {
			modelAndView.addObject("message", "Désolé, ce lien n'est plus valide !");
			modelAndView.setViewName("account_error");
		}

		return modelAndView;
	}

	// Login
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public ModelAndView displayLogin(ModelAndView modelAndView, Users users) {
		modelAndView.addObject("users", users);
		modelAndView.setViewName("login_page");
		return modelAndView;
	}

//	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
//	public ModelAndView loginUser(ModelAndView modelAndView, Users users) {
//
//		Users existingUsers = usersRepository.findByEmailIgnoreCase(users.getEmail());
//		if (existingUsers != null) {
//			// use encoder.matches to compare raw password with encrypted password
//
//			if (encoder.matches(users.getPassword(), existingUsers.getPassword())) {
//				// successfully logged in
//				modelAndView.setViewName("index");
//			} else {
//				// wrong password
//				modelAndView.addObject("message", "Mot de passe incorrect. Réessayer.");
//				modelAndView.setViewName("login_page");
//			}
//		} else {
//			modelAndView.addObject("message", "Cet adresse E-mail n'existe pas !");
//			modelAndView.setViewName("login_page");
//
//		}
//
//		return modelAndView;
//	}

	/**
	 * Display the forgot password page and form
	 */
	@RequestMapping(value = "/oublie-password", method = RequestMethod.GET)
	public ModelAndView displayResetPassword(ModelAndView modelAndView, Users users) {
		modelAndView.addObject("users", users);
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
	}

	/**
	 * Receive email of the user, create token and send it via email to the user
	 */
	@RequestMapping(value = "/oublie-password", method = RequestMethod.POST)
	public ModelAndView forgotUserPassword(ModelAndView modelAndView, Users users) {
		Users existingUsers = usersRepository.findByEmailIgnoreCase(users.getEmail());
		if (existingUsers != null) {
			// create token
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUsers);

			// save it
			confirmationTokenRepository.save(confirmationToken);

			// create the email
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUsers.getEmail());
			mailMessage.setSubject("Réinitialisation du mot de passe !");
			mailMessage.setFrom("contact.driveat@gmail.com");
			mailMessage
					.setText("Pour finaliser votre demande de réinitialisation de mot de passe, cliquez sur ce lien : "
							+ "http://localhost:8080/confirm-reset?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendEmail(mailMessage);

			modelAndView.addObject("message",
					"Demande de réinitialisation du mot de passe envoyer. Vérifiez votre boîte E-mail.");
			modelAndView.setViewName("successForgotPassword");

		} else {
			modelAndView.addObject("message", "Cet adresse E-mail n'existe pas !");
			modelAndView.setViewName("account_error");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/confirm-reset", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			Users users = usersRepository.findByEmailIgnoreCase(token.getUsers().getEmail());
			users.setEnabled(true);
			usersRepository.save(users);
			modelAndView.addObject("users", users);
			modelAndView.addObject("email", users.getEmail());
			modelAndView.setViewName("resetPassword");
		} else {
			modelAndView.addObject("message", "Désolé, ce lien n'est plus valide !");
			modelAndView.setViewName("account_error");
		}

		return modelAndView;
	}

	/**
	 * Receive the token from the link sent via email and display form to reset
	 * password
	 */
	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public ModelAndView resetUserPassword(ModelAndView modelAndView, Users users) {

		// ConfirmationToken token =
		// confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (users.getEmail() != null) {
			// use email to find user
			Users tokenUsers = usersRepository.findByEmailIgnoreCase(users.getEmail());
			tokenUsers.setEnabled(true);
			tokenUsers.setPassword(encoder.encode(users.getPassword()));

			// System.out.println(tokenUser.getPassword());

			usersRepository.save(tokenUsers);
			modelAndView.addObject("message",
					"Votre mot de passe a bien été réinitialisé. Vous pouvez maintenant vous connecter.");
			modelAndView.setViewName("login_page");
		} else {
			modelAndView.addObject("message", "Désolé, ce lien n'est plus valide !");
			modelAndView.setViewName("account_error");
		}

		return modelAndView;
	}

	//logout
	@RequestMapping(value = "/déconnexion", method = RequestMethod.GET)
	public ModelAndView getLogoutPage(ModelAndView modelAndView) {
		modelAndView.setViewName("login_page");
		return modelAndView;
	}
	
	public UsersRepository getusersRepository() {
		return usersRepository;
	}

	public void setusersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public ConfirmationTokenRepository getConfirmationTokenRepository() {
		return confirmationTokenRepository;
	}

	public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
		this.confirmationTokenRepository = confirmationTokenRepository;
	}

	public EmailSenderService getEmailSenderService() {
		return emailSenderService;
	}

	public void setEmailSenderService(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

}
