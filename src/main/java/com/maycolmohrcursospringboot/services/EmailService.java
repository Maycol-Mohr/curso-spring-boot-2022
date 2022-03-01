package com.maycolmohrcursospringboot.services;

import org.springframework.mail.SimpleMailMessage;

import com.maycolmohrcursospringboot.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
