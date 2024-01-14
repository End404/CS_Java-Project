package com.neo.helloworld1.service;


import com.neo.helloworld1.hello.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/***
 * 慕课网——Spring Boot 发送邮件
 * 2-4 文本
 * 2-5 HTML
 * 2-6 附件
 * 2-7 图片
 * 2-8 模板
 * 2-9 异常处理
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sayHelloTest(){
        mailService.sayHello();
    }

    @Test
    public void sendSimpleMailTest(){
        mailService.sendSimpleMail("ityouknow@126.com", "这是第一封邮件",
                "大家好，这事务的第一封邮件");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content = "<html>\n" +
                "<body>\n" +
                "<h3> hello world,这是一封HTML邮件！</h3>\n"+
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail("ityouknow@126.com","这是一封Html邮件", content);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        String filePath="D:\\ProgramData\\IntelliJ-IDEA-2020\\慕课网-SpringBoot发送邮件\\附件邮件文本.txt";
        mailService.sendAttachmentsMail("xxx@126.com", "这是附件邮件", "这是附件邮件的内容",filePath);
    }

    @Test
    public void sendInlineResurceMailTest() {
        String imgPath="D:\\ProgramData\\IntelliJ-IDEA-2020\\慕课网-SpringBoot发送邮件\\1.jpg";
        String rscId="neo001";
        String content="<html><body> 这是有图片的邮件:<img src=\'cid:"+rscId
                + "\'> </img>+" +
                "<img src=\'cid:"+rscId
                + "\'> </img>" +
                " </body></html>";
        mailService.sendInlinResourceMail("xxx@126.com", "这是一个图片邮件",content,
                imgPath, rscId);
    }

    @Test
    public void testTmeplateMailTest() throws MessagingException {
        Context context=new Context();
        context.setVariable("id","006");

        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("xxx@126.com","这是一个模板邮件", emailContent);
    }

}

