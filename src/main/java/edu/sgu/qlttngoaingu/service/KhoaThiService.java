package edu.sgu.qlttngoaingu.service;

import edu.sgu.qlttngoaingu.entity.KhoaThi;
import edu.sgu.qlttngoaingu.entity.PhongThi;
import edu.sgu.qlttngoaingu.repository.KhoaThiRepository;
import edu.sgu.qlttngoaingu.repository.PhongThiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaThiService {
    @Autowired
    private KhoaThiRepository khoaThiRepository;
    @Autowired
    private PhongThiRepository phongThiRepository;
    public List<KhoaThi> getAll(){
        return khoaThiRepository.findAll();
    }
    public List<PhongThi> getPhongThi(){
      return   phongThiRepository.findAll();
    }
}
