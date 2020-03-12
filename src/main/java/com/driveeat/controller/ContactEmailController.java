package com.driveeat.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.driveeat.entity.Contact;

@Controller
public class ContactEmailController {

	@Autowired
	public JavaMailSender emailSender;

	@PostMapping("/sendEmail")
	public String sendEmail(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult)
			throws MessagingException {

		if (bindingResult.hasErrors()) {
             System.out.println(bindingResult.getFieldError());
			return "contact";

		} else {

			MimeMessage mailling = emailSender.createMimeMessage();

			boolean multipart = true;
			MimeMessageHelper helper = new MimeMessageHelper(mailling, multipart, "utf-8");

			String htmlMsg = "<h3>Un client vient de vous envoyer un message.</h3><br>" + "<b>Nom: </b>"
					+ contact.getFirstName() + " " + contact.getLastName() + "<br><b>Email : </b>" + contact.getMail()
					+ "<br><b>Phone : </b>" + contact.getPhone() + "<h4>Message :</h4> " + contact.getMessage();

			mailling.setContent(htmlMsg, "text/html");

			helper.setTo(Contact.FRIEND_EMAIL);

			helper.setSubject("Demande de contact d'un client.");

			// Send Message!
			this.emailSender.send(mailling);

			return "redirect:/contact";

		}
	}
}
