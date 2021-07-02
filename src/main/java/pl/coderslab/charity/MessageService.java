package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final JavaMailSender javaMailSender;

    public MessageService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("charitylabemail@gmail.com");
        mailMessage.setText(message);
        mailMessage.setTo("charitylabemail@gmail.com");

        javaMailSender.send(mailMessage);

    }
}
