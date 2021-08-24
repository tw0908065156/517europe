package cn.tedu.aeurope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
	@Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tw517europe@gmail.com");
        message.setTo("2834569780@qq.com");
        message.setSubject("主旨：Hello J.J.Huang");
        message.setText("內容：這是一封測試信件，恭喜您成功發送了唷");

        mailSender.send(message);
    }
}
