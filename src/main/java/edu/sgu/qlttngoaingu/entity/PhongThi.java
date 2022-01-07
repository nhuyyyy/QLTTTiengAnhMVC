package edu.sgu.qlttngoaingu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phongthi")
@Data
public class PhongThi {
    @Id
    @Column(name = "phong_thi_id")
    private Integer id;
    @Column(name = "ten_phong_thi")
    private String name;
}
