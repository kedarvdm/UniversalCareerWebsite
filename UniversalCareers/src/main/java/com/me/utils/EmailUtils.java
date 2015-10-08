package com.me.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	public static boolean sendApplicantMail(EmailDetails emailDetails){
		  final String gmailu = "stegobanking@gmail.com";
		  final String gmailp = "stego123";
  		  String to = emailDetails.getTo();
		  String from = "stegobanking@gmail.com";
		  Properties properties = System.getProperties();
		  properties.put("mail.smtp.auth", "true");
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.host", "smtp.gmail.com");
		  properties.put("mail.smtp.port", "587");
		  javax.mail.Session session = javax.mail.Session.getDefaultInstance(
				  properties, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(gmailu, gmailp);
						}
				  });
		  	try{
		      MimeMessage message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(from));
		      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		      message.setSubject(emailDetails.getSubject());
		      message.setContent("<p>"+emailDetails.getBody()+"</p>", "text/html");
		      Transport.send(message);
		      return true;
		  	}catch (MessagingException ex) {
			  System.out.println("Error Sending Email.");
		      ex.printStackTrace();
		      return false;
		  	}
	}
}
