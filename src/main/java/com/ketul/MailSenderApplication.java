package com.ketul;

import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.ketul.service.MailService;

@SpringBootApplication
public class MailSenderApplication {
	
	@Autowired
	private MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		mailService.sendSimpleMail("<Enter receive Mail>", "<Enter Body of mail>", "<Enter subject of mail>");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMailWithAttechment() throws MessagingException {
		mailService.sendMailWithAttechment("<Enter receive Mail>", "<Enter Body of mail>", "<Enter subject of mail>", "<Path for your Attechment>");
	}
}
