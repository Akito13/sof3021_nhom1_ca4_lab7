package com.example.sof3021_nhom1_ca4_lab7.Controller;

import com.example.sof3021_nhom1_ca4_lab7.Model.MailInfo;
import com.example.sof3021_nhom1_ca4_lab7.Service.MailerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class Bai3Controller {

    @Autowired
    MailerServiceImpl service;

    @RequestMapping("/mail/form")
    public String formMail(@ModelAttribute ("sender") MailInfo sender ){
        return "Bai3";
    }
    
    @RequestMapping("/mail/send")
    public String sendMail(@ModelAttribute ("sender") MailInfo sender,
                           @RequestParam("attachments") MultipartFile[] submittedFiles,
                           Model model){
        sender.setAttachments(submittedFiles);
        try {
            service.send(sender);
            model.addAttribute("message", "Gửi thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
        }
        return "Bai3";
    }
}
