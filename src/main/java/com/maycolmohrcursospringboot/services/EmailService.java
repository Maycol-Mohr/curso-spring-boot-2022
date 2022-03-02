package com.maycolmohrcursospringboot.services;

import org.springframework.mail.SimpleMailMessage;

import com.maycolmohrcursospringboot.domain.Cliente;
import com.maycolmohrcursospringboot.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	//void sendHtmlEmail(MimeMessage msg);
	
	void  sendNewPasswordEmail(Cliente cliente, String newPass);
}
