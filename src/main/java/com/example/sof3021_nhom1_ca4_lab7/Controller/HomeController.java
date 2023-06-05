package com.example.sof3021_nhom1_ca4_lab7.Controller;

import com.example.sof3021_nhom1_ca4_lab7.Model.Loai;
import com.example.sof3021_nhom1_ca4_lab7.Repository.LoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    LoaiRepository repository;

    @RequestMapping("/home/index")
    public String index(Model model) {
        List<Loai> list = repository.findAll();
        model.addAttribute("loai",list);

        return "Bai4/index";
    }


    @RequestMapping("/home/about")
    public String about() {
        return "Bai4/global";
    }
}
