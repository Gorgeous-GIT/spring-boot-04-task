package com.atguigu.task;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04TaskApplicationTests {
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	
	@Test
	public void contextLoads() {
		SimpleMailMessage message=new SimpleMailMessage();
		//邮件设置
		message.setSubject("通知-今晚开会");
		message.setText("今晚7:30开会");
		message.setTo("1340653426@qq.com");
		message.setFrom("392555078@qq.com");
		mailSender.send(message);
	}
	
	@Test
	public void test02() throws Exception{
		MimeMessage mailmessage=mailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mailmessage,true);
		//邮件设置
		helper.setSubject("通知-今晚开会");
		helper.setSubject("<b style='color'>今天 7:30 开会</b>");
		helper.setTo("1340653426@qq.com");
		helper.setFrom("392555078@qq.com");
		//上传文件
		helper.addAttachment("1.jpg",new File(""));
		helper.addAttachment("2.jpg",new File(""));
		mailSender.send(mailmessage);
	}

}
