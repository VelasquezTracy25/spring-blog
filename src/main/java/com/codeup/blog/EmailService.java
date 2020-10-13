package com.codeup.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service("mailService")
public class EmailService {

    private final UserRepository userDao;

    @Autowired
    public JavaMailSender emailSender;

    public EmailService(UserRepository userDao) {
        this.userDao = userDao;
    }

//    @Value("${spring.mail.from}")
//    private String from;

    public void prepareAndSend(Post post, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(from);
        msg.setTo(userDao.getOne((long) 1).getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try {
            this.emailSender.send(msg);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}

//class RunnableEmail implements Runnable {
//    private EmailService emailService;
//    private SimpleMailMessage msg;
//
//    public RunnableEmail(EmailService emailService, SimpleMailMessage msg) {
//        this.emailService = emailService;
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        try {
//            emailService.emailSender(ex.getMessage())
//        }
//
//    }
//}
