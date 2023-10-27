/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Class.Oto;
import Class.QuanLyOTo;
import Class.QuanLyNhanVien;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class QuanLyOtoModel {
    public boolean themOto(Oto oto) throws Exception {
        return QuanLyOTo.themOto(oto);
    }
    public boolean xoaOto(String maOto) throws Exception{
        return QuanLyOTo.xoaOto(maOto);
    }
    public boolean suaOto(Oto oto) throws Exception{
        return QuanLyOTo.suaOto(oto);
    }
    
    public ArrayList<Oto> timKiemTheoMaXe(String maXe) throws Exception {
        return QuanLyOTo.timKiemTheoMaXe(maXe);
    }
    public ArrayList<Oto> timKiemTheoTenXe(String tenXe) throws Exception {
        return QuanLyOTo.timKiemTheoTenXe(tenXe);
    }
    public ArrayList<Oto> timKiemTheoXuatXu(String xuatXu) throws Exception {
        return QuanLyOTo.timKiemTheoXuatXu(xuatXu);
    }
    public ArrayList<Oto> danhSachOto() throws Exception{
        return QuanLyOTo.docDuLieu();
    }
    public ArrayList<Oto> sapXepTheoMa() {
       return QuanLyOTo.SapXepOto();
    }
    public ArrayList<Oto> sapXepTheoTen() {
       return QuanLyOTo.SapXepTenOto();
    }
    public ArrayList<Oto> sapXepTheoGiaBan() {
       return QuanLyOTo.SapXepTheoGiaBan();
    }
    public ArrayList<Oto> sapXepTheoSoLuong() {
       return QuanLyOTo.SapXepTheoSoLuong();
    }
    public ArrayList<Oto> timKiemHangTonKho()throws Exception {
       return QuanLyOTo.timKiemTonKho();
    }
    public ArrayList<Oto> timKiemChuaThanhToan() throws Exception{
       return QuanLyOTo.timKiemChuaThanhToan();
    }
    public boolean kiemTraDangNhap(String maNV, String matKhau){
        return QuanLyNhanVien.kiemTraDangNhap(maNV, matKhau);
    }
}
