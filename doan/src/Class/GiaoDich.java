/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Date;

/**
 *
 * @author PC
 */
public class GiaoDich {
    private String maGiaoDich;
    private String thoiGian;
    private String khachHang;
    private String nhanVien;
    private String trangThai;
    private double giaBan;
    private int soLuong;
    private String oto;

    public GiaoDich() {
    }

    public GiaoDich(String maGiaoDich, String thoiGian, String khachHang, String nhanVien, String trangThai, double giaBan, int soLuong, String oto) {
        this.maGiaoDich = maGiaoDich;
        this.thoiGian = thoiGian;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.trangThai = trangThai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.oto = oto;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getOto() {
        return oto;
    }

    public void setOto(String oto) {
        this.oto = oto;
    }

    @Override
    public String toString() {
        return "GiaoDich{" + "maGiaoDich=" + maGiaoDich + ", thoiGian=" + thoiGian + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", trangThai=" + trangThai + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", oto=" + oto + '}';
    }

    
   
}
