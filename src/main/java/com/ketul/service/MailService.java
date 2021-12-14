package com.ketul.service;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ketul.module.MailUser;
import com.ketul.repo.MailUserRepo;

@Service
public class MailService {

	@Autowired
	private MailUserRepo mailUserRepo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleMail(String toMail, String body, String subject) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom("<Enter Your Mail whose sent from>");
		mailMessage.setTo(toMail);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		mailSender.send(mailMessage);
	}
	
	public void sendMailWithAttechment(String toMail, String body, String subject, String attechment) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setFrom("<Enter Your Mail whose sent from>");
		helper.setTo(toMail);
		helper.setText(body);
		helper.setSubject(subject);
		
		FileSystemResource filResource = new FileSystemResource(new File(attechment));
		
		helper.addAttachment(filResource.getFilename(), filResource);
		
		mailSender.send(message);
		
	}

	public MailUser saveMailUser(MailUser mailUser) {
		List<MailUser> list = mailUserRepo.findAll();
		
		if(list.size() > 0)
			mailUser.setId(list.get(list.size() - 1).getId() + 1);
		else
			mailUser.setId(1);
		MailUser mailUser2 = mailUserRepo.save(mailUser);
		
		return mailUser2;
	}
	
	public void sentMail() {
		List<MailUser> list = mailUserRepo.findAll();
		
		for(MailUser user : list)
			sendSimpleMail(user.getToMail(), user.getMessage(), user.getSubject());
	}
}
