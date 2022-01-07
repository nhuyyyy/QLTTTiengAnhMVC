package edu.sgu.qlttngoaingu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class DangKiForm {
    private String hoTen;
    private String ngaySinh;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String trinhDo;
    private Integer khoaThiId;
}
