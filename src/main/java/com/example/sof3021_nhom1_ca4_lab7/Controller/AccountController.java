package com.example.sof3021_nhom1_ca4_lab7.Controller;

import com.example.sof3021_nhom1_ca4_lab7.Model.Account;
import com.example.sof3021_nhom1_ca4_lab7.Service.AccountDAO;
import com.example.sof3021_nhom1_ca4_lab7.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    AccountDAO dao;
    @Autowired
    SessionService session;

    @GetMapping("/account/login")
    public String login() {
        return "account/login";
    }
    @GetMapping("/admin/index")
    public String adminInex() {
        return "admin/index";
    }
    @GetMapping("/admin/loginIndex")
    public String loginIndex() {
        return "admin/loginIndex";
    }


    @PostMapping("/account/login")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        try {
            Account user = dao.getOne(username);
            if (!user.getPassword().equals(password)) {
                model.addAttribute("message", "Invalid password");
            } else {
                session.set("user", user);
                String uri = (String) session.get("security-uri");
                if (uri != null) {
                    return "redirect:" + uri;
                } else {
                    model.addAttribute("message", "Login succeed");
                }
            }
        } catch (Exception e) {
            model.addAttribute("message", "Invalid username");
        }
        return "account/login";
    }
}
