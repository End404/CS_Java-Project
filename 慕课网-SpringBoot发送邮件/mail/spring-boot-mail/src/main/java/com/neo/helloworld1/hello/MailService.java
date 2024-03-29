package com.neo.helloworld1.hello;

/***
 *
 * 慕课网——SpringBoot 发送邮件
 * 2-4
 * 2-5
 * 2-6
 * 2-7
 * 2-9 异常处理
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    public void sayHello(){
        System.out.println("Hello world");
    }

    public void sendSimpleMail(String to, String subject,
                               String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);

        mailSender.send(message);
    }

    public void sendHtmlMail(String to, String subject,
                             String content) throws MessagingException {
        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    public void sendAttachmentsMail(String to, String subject,
                                    String content,String filePath) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();

        MimeMessageHelper helper= new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName=file.getFilename();
        helper.addAttachment(fileName,file);
        helper.addAttachment(fileName+"_test",file);
        mailSender.send(message);
    }

    public void sendInlinResourceMail(String to, String subject, String content,
                                      String rscPath, String rscId)  {

        logger.info("发生静态邮件开始：{},{},{},{},{}", to,subject,content,rscPath,rscId);
        MimeMessage message=mailSender.createMimeMessage();

        MimeMessageHelper helper= null;
        try {   //2-9 异常处理
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource res=new FileSystemResource(new File(rscPath));
            helper.addInline(rscId,res);
            helper.addInline(rscId,res);
            mailSender.send(message);
            logger.info("发生静态图片邮件成功！");
        } catch (MessagingException e) {
            logger.error("发生静态邮件失败: ", e);
        }

    }

}

