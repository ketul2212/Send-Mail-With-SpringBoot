package com.ketul.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ketul.module.MailUser;
import com.ketul.module.dto.MailUserDto;
import com.ketul.service.MailService;

@RestController
public class MailUserResource {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/save")
	public MailUser save(@RequestBody MailUserDto mailUserDto) {
		MailUser mailUser = mapper.map(mailUserDto, MailUser.class);
		return mailService.saveMailUser(mailUser);
	}
	
	@GetMapping("/sendMail")
	public void getMail() {
		mailService.sentMail();
	}
}
