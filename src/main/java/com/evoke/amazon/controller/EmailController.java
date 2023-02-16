package com.evoke.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.amazon.entity.EmailDetails;
import com.evoke.amazon.service.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	 
    // Sending a simple Email
   
	@PostMapping("/sendMail")
  
	public String  sendMail(@RequestBody EmailDetails details)
  
    {
        String status = emailService.sendSimpleMail(details);
        return status;
    }

}
