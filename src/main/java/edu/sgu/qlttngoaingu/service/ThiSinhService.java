package edu.sgu.qlttngoaingu.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import edu.sgu.qlttngoaingu.dto.DangKiForm;
import edu.sgu.qlttngoaingu.dto.DanhSachThiSinh;
import edu.sgu.qlttngoaingu.dto.ThongTinThiSinh;
import edu.sgu.qlttngoaingu.entity.KhoaThi;
import edu.sgu.qlttngoaingu.entity.PhieuDangKy;
import edu.sgu.qlttngoaingu.entity.PhieuDangKyId;
import edu.sgu.qlttngoaingu.repository.KhoaThiRepository;
import edu.sgu.qlttngoaingu.repository.PhieuDangKyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sgu.qlttngoaingu.entity.ThiSinh;
import edu.sgu.qlttngoaingu.repository.ThiSinhRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThiSinhService {
    @Autowired
    private ThiSinhRepository thiSinhRepository;
    @Autowired
    private PhieuDangKyRepository phieuDangKyRepository;

    @Transactional
    public void dangKy(DangKiForm dangKiForm){
        ThiSinh thiSinh= new ThiSinh();
        thiSinh.setNgaySinh(stringToDate(dangKiForm.getNgaySinh()));
        thiSinh.setCmnd(dangKiForm.getCmnd());
        thiSinh.setEmail(dangKiForm.getEmail());
        thiSinh.setHoTen(dangKiForm.getHoTen());
        thiSinh.setSoDienThoai(dangKiForm.getSoDienThoai());
        ThiSinh result= thiSinhRepository.save(thiSinh);
        PhieuDangKy dangKy= new PhieuDangKy();
        dangKy.setNgayDangKy(new Date());
        dangKy.setTrinhDo(dangKiForm.getTrinhDo());
        PhieuDangKyId phieuDangKyId= new PhieuDangKyId();
        phieuDangKyId.setThiSinhId(result.getThiSinhId());
        phieuDangKyId.setKhoaThiId(dangKiForm.getKhoaThiId());
        dangKy.setId(phieuDangKyId);
        phieuDangKyRepository.save(dangKy);
    }
    private Date stringToDate(String date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        try {
            startDate = df.parse(date);
            return startDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<ThongTinThiSinh> getThogTinThiSinhs(String name, String phone){
        try {
            List<Object[]> objects= thiSinhRepository.getThiSinh(name,phone);
            List<ThongTinThiSinh> result= new ArrayList<>();
            objects.stream().forEach(s->{
                ThongTinThiSinh thongTinThiSinh= new ThongTinThiSinh();
                thongTinThiSinh.setSoBaoDanh(s[0]!=null?s[0].toString():"");
                thongTinThiSinh.setPhong(s[1]!=null?s[1].toString():"");
                thongTinThiSinh.setNghe(s[2]!=null?Float.parseFloat(s[2].toString()):0);
                thongTinThiSinh.setNoi(s[3]!=null?Float.parseFloat(s[3].toString()):0);
                thongTinThiSinh.setDoc(s[4]!=null?Float.parseFloat(s[4].toString()):0);
                thongTinThiSinh.setViet(s[5]!=null?Float.parseFloat(s[5].toString()):0);
                result.add(thongTinThiSinh);
            });
            return result;
        }
        catch (Exception e){

        }
        return null;
    }
    public List<DanhSachThiSinh>  getDanhSachThiSinh(Integer id,Boolean option){
        try {
            List<Object[]> objects= new ArrayList<>();
           if (option){
               objects = thiSinhRepository.getThiSinhByKhoaThi(id);
           }
           else {
               objects=thiSinhRepository.getThiSinhByPhongThi(id);
           }
            List<DanhSachThiSinh> result= new ArrayList<>();
            objects.stream().forEach(s->{
                DanhSachThiSinh danhSachThiSinh= new DanhSachThiSinh();
                danhSachThiSinh.setTen(s[0]!=null?s[0].toString():"");
                danhSachThiSinh.setSoBaoDanh(s[1]!=null?s[1].toString():"");
                danhSachThiSinh.setCmnd(s[2]!=null?s[2].toString():"");
                danhSachThiSinh.setSoDienThoai(s[3]!=null?s[3].toString():"");
                danhSachThiSinh.setNoiSinh(s[4]!=null?s[4].toString():"");
                result.add(danhSachThiSinh);
            });
            return result;
        }
        catch (Exception e){

        }
        return null;
    }

}
