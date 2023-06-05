package com.example.sof3021_nhom1_ca4_lab7.Service;

import com.example.sof3021_nhom1_ca4_lab7.Model.MailInfo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class MailerServiceImpl implements MailerService{

    @Autowired
    JavaMailSender sender;
    List<MimeMessage> list = new ArrayList<>();

    @Override
    public void send(MailInfo mail) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        helper.setFrom(mail.getFrom());
        helper.setTo(InternetAddress.parse(mail.getTo()));
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody(),true);
        helper.setReplyTo(mail.getFrom());

        String[] cc = mail.getCc();
        if(cc != null && cc.length >0) {
            helper.setCc(cc);
        }
        String[] bcc = mail.getBcc();
        if(bcc != null && bcc.length > 0) {
            helper.setBcc(bcc);
        }

        MultipartFile[] attachments = mail.getAttachments();
        if(attachments != null && attachments.length > 0) {
            for(MultipartFile file: attachments) {
                helper.addAttachment(file.getName(), file);
            }
        }
        list.add(message);
    }

    @Scheduled(fixedDelay = 5000)
    public void run(){
        while (!list.isEmpty()){
            MimeMessage message = list.remove(0);
            try{
                sender.send(message);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    @Override
    public void send(String from, String to, String subject, String body) throws MessagingException {
        this.send(new MailInfo(from,to,subject,body));
    }
}

