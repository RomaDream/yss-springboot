package com.example.demo.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private static Logger log = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	/**
	 * 发送邮件
	 * @param from
	 *   		发件人
	 * @param to
	 * 			收件人
	 * @param subject
	 * 			主题
	 * @param content
	 * 			内容
	 */
	public void send(String from, String to, String subject, String content) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(content);
			mailSender.send(mailMessage);
		} catch (Exception e) {
			log.error("邮件发送失败", e);
		}
	}
}
