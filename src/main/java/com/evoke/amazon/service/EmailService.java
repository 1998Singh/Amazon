package com.evoke.amazon.service;

import com.evoke.amazon.entity.EmailDetails;

public interface EmailService {

	public String sendSimpleMail(EmailDetails details);

}
