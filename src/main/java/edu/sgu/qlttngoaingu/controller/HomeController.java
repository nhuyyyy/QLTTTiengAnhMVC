package edu.sgu.qlttngoaingu.controller;

import edu.sgu.qlttngoaingu.dto.DangKiForm;
import edu.sgu.qlttngoaingu.service.KhoaThiService;
import edu.sgu.qlttngoaingu.service.ThiSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private KhoaThiService khoaThiService;
    @Autowired
    private ThiSinhService thiSinhService;
    @RequestMapping(value = {"/","/index.html","/index"})
    public String add(Model model){
        DangKiForm dangKiForm= new DangKiForm();
        model.addAttribute("dangKiForm",dangKiForm);
        model.addAttribute("khoathis",khoaThiService.getAll());
        return "home";
    }
    @RequestMapping(value = "/dang-ky",method = RequestMethod.POST)
    public String add(@Valid DangKiForm dangKiForm,Model model){
        thiSinhService.dangKy(dangKiForm);
        return "redirect:/index.html";

    }
}
