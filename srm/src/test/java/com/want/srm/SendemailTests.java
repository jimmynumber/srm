//package com.want.srm;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.want.srm.service.impl.MailServiceImpl;
//
///**
// * 
// * @ClassName: SendemailTests
// * @Description: 邮件发送测试类
// * @author 00418053
// * @date Oct 19, 2020
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SendemailTests {
//	@Autowired
//	private MailServiceImpl mailSevcie;
//
//	    /**
//	     * 测试发送文本邮件
//	     */
//	    @Test
//	    public void sendmail() {
//	    	mailSevcie.sendSimpleMail("435453564@qq.com","主题：你好普通邮件","内容：第一封邮件");
//	    }
//
//	    @Test
//	    public void sendmailHtml(){
//	    	mailSevcie.sendHtmlMail("435453564@qq.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
//	    }
//}
