/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Class.GiaoDich;
import Class.QuanLyGiaoDich;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class QuanLyGiaoDichModel {
    public ArrayList<GiaoDich> inDanhSach(){
        return QuanLyGiaoDich.docDuLieu();
    }
    public boolean themGiaoDich(GiaoDich giaoDich){
        return QuanLyGiaoDich.themGiaoDich(giaoDich);
    }
    public ArrayList<GiaoDich> timKiemGiaoDich(String giaoDich)throws Exception{
        return QuanLyGiaoDich.timKiem(giaoDich);
    }
    public ArrayList<GiaoDich> timKiemChuaGiaoHang() throws Exception{
        return QuanLyGiaoDich.timKiemChuaGiaoHang();
    }
    public ArrayList<GiaoDich> timKiemDangGiaoHang() throws Exception{
        return QuanLyGiaoDich.timKiemDangGiaoHang();
    }
    public ArrayList<GiaoDich> timKiemĐaHoanThanh() throws Exception{
        return QuanLyGiaoDich.timKiemĐaHoanThanh();
    }
    public ArrayList<GiaoDich> SapXepTheoMa() throws Exception{
        return QuanLyGiaoDich.SapXepTheoMa();
    }
    public ArrayList<GiaoDich> SapXepTheoTenKhachHang() throws Exception{
        return QuanLyGiaoDich.SapXepTheoTenKhachHang();
    }
    public ArrayList<GiaoDich> SapXepTheoTenNhanVien() throws Exception{
        return QuanLyGiaoDich.SapXepTheoTenNhanVien();
    }
    public ArrayList<GiaoDich> SapXepTheoThoiGian() throws Exception{
        return QuanLyGiaoDich.SapXepTheoThoiGian();
    }
    
}
