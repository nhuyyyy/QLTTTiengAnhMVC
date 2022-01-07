package edu.sgu.qlttngoaingu.controller;

import edu.sgu.qlttngoaingu.dto.DanhSachThiSinh;
import edu.sgu.qlttngoaingu.dto.DanhSachThiSinhForm;
import edu.sgu.qlttngoaingu.dto.ThiSinhForm;
import edu.sgu.qlttngoaingu.dto.ThongTinThiSinh;
import edu.sgu.qlttngoaingu.entity.KhoaThi;
import edu.sgu.qlttngoaingu.entity.PhongThi;
import edu.sgu.qlttngoaingu.entity.ThiSinh;
import edu.sgu.qlttngoaingu.service.KhoaThiService;
import edu.sgu.qlttngoaingu.service.ThiSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThiSinhController {
    @Autowired
    private ThiSinhService thiSinhService;
    @Autowired
    private KhoaThiService khoaThiService;
    @RequestMapping(value = {"/thong-tin-thi-sinh.html"})
    public String index(Model model){
        model.addAttribute("thiSinhForm",new ThiSinhForm());
        return "thong-tin-thi-sinh";
    }
    @RequestMapping(value = {"/thong-tin-thi-sinh.html"},method = RequestMethod.POST)
    public String index(ThiSinhForm thiSinhForm,Model model){
        List<ThongTinThiSinh> list =  thiSinhService.getThogTinThiSinhs(thiSinhForm.getName(),thiSinhForm.getPhone());
        model.addAttribute("list",list);
        return "thong-tin-thi-sinh";
    }
    @RequestMapping(value = {"/danh-sach-thi-sinh.html"})
    public String list(Model model){
        List<KhoaThi> khoaThis= khoaThiService.getAll();
        List<PhongThi> phongThis= khoaThiService.getPhongThi();
        model.addAttribute("khoaThis",khoaThis);
        model.addAttribute("phongThis",phongThis);
        model.addAttribute("danhSachThiSinhForm", new DanhSachThiSinhForm());
        return "danh-sach-thi-sinh";
    }
    @RequestMapping(value = {"/danh-sach-thi-sinh.html"},method = RequestMethod.POST)
    public String list(Model model, DanhSachThiSinhForm danhSachThiSinhForm){
        List<DanhSachThiSinh> danhSachThiSinhs= new ArrayList<>();
        List<KhoaThi> khoaThis= khoaThiService.getAll();
        List<PhongThi> phongThis= khoaThiService.getPhongThi();
        model.addAttribute("khoaThis",khoaThis);
        model.addAttribute("phongThis",phongThis);
        if (danhSachThiSinhForm.getOption().equals("K")){
            danhSachThiSinhs=thiSinhService.getDanhSachThiSinh(danhSachThiSinhForm.getKhoaThiId(),true);
        }
        else{
            danhSachThiSinhs=thiSinhService.getDanhSachThiSinh(danhSachThiSinhForm.getPhongThiId(),false);
        }
        model.addAttribute("danhSachThiSinhs",danhSachThiSinhs);
        return "danh-sach-thi-sinh";
    }
}
