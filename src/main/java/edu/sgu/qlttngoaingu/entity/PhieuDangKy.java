package edu.sgu.qlttngoaingu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "phieudangky")
@Data
public class PhieuDangKy implements Serializable {
    @EmbeddedId
    private PhieuDangKyId id;
    @Column(name = "trinh_do")
    private String trinhDo;
    @Column(name = "ngay_dang_ky")
    private Date ngayDangKy;
}
