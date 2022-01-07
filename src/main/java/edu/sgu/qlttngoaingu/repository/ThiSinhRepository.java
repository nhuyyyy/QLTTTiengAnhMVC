package edu.sgu.qlttngoaingu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sgu.qlttngoaingu.entity.ThiSinh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThiSinhRepository extends JpaRepository<ThiSinh,Integer> {
    @Query(value="SELECT so_bao_danh,ten_phong_thi,nghe,noi,doc,viet from thisinh,danhsachphongthi,phongthi WHERE thisinh.thi_sinh_id=danhsachphongthi.thi_sinh_id and phongthi.phong_thi_id=danhsachphongthi.phong_thi_id and thisinh.ho_ten=:name and thisinh.so_dien_thoai=:phone", nativeQuery = true)
    List<Object[]> getThiSinh(@Param("name") String name, @Param("phone") String phone );
    @Query(value="SELECT thisinh.ho_ten, danhsachphongthi.so_bao_danh, thisinh.cmnd, thisinh.so_dien_thoai, thisinh.noi_sinh FROM thisinh, danhsachphongthi,phongthi WHERE phongthi.phong_thi_id=danhsachphongthi.phong_thi_id and danhsachphongthi.thi_sinh_id=thisinh.thi_sinh_id and phongthi.phong_thi_id=:id",nativeQuery = true)
    List<Object[]> getThiSinhByPhongThi(@Param("id")Integer phong);
    @Query(value="SELECT thisinh.ho_ten, danhsachphongthi.so_bao_danh, thisinh.cmnd, thisinh.so_dien_thoai, thisinh.noi_sinh FROM thisinh, danhsachphongthi,phongthi, khoathi WHERE phongthi.phong_thi_id=danhsachphongthi.phong_thi_id and danhsachphongthi.thi_sinh_id=thisinh.thi_sinh_id and khoathi.khoa_thi_id=phongthi.khoa_thi_id and khoathi.khoa_thi_id=:id",nativeQuery = true)
    List<Object[]> getThiSinhByKhoaThi(@Param("id")Integer khoa);
}
