package edu.sgu.qlttngoaingu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@Data
public class PhieuDangKyId implements Serializable {
    @Column(name = "khoa_thi_id")
    private Integer khoaThiId;
    @Column(name = "thi_sinh_id")
    private Integer thiSinhId;
}
