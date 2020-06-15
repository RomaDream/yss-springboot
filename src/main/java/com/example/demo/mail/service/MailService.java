package com.example.demo.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private static Logger log = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public void send() {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(from);
			mailMessage.setTo("chenhui@hollycrm.com");
			mailMessage.setSubject("测试主题");
			mailMessage.setText("邮件内容");
			mailSender.send(mailMessage);
		} catch (Exception e) {
			log.error("短信发送失败", e);
		}
	}
}
