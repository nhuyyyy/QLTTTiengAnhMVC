package edu.sgu.qlttngoaingu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "khoathi")
@Data
public class KhoaThi  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "khoa_thi_id")
    private Integer khoaThiId;
    @Column(name = "ten_khoa")
    private String tenKhoa;
    @Column(name = "ngay_bat_dau")
    private Date ngayThi;
}
