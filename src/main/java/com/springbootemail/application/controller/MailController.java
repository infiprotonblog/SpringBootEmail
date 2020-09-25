package com.springbootemail.application.controller;

import com.springbootemail.application.model.User;
import com.springbootemail.application.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private User user;

	@RequestMapping("send-mail")
	public String send() {

		user.setFirstName("Robin");
		user.setLastName("sharma");
		user.setEmailAddress("***@gmail.com"); //Receiver's email address

		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

		user.setFirstName("Robin");
		user.setLastName("sharma");
		user.setEmailAddress("***@gmail.com"); //Receiver's email address

		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}
