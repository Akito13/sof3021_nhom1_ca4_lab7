package com.example.sof3021_nhom1_ca4_lab7.Service;

import com.example.sof3021_nhom1_ca4_lab7.Model.MailInfo;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

public interface MailerService {

    void send(MailInfo mail) throws MessagingException;

    void send(String from, String to, String subject, String body) throws MessagingException;
}
