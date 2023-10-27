/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Class.Oto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author hp
 */
public class QuanLyOTo {

    public static Connection c;
    private static String db_url = "jdbc:mysql://localhost:3306/ql_showroom";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(db_url, username, password);
        }
        return c;
    }

    public static boolean themOto(Oto oto) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "INSERT INTO oto(MaXe, TenXe, MauSacNoiThat, XuatXu, DongCo, MoTa, Gia, SoGhe, TrangThai, ChieuDai, ChieuCao, SoLuong, HinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, oto.getMaXeString());
            ps.setString(2, oto.getTenXeString());
            ps.setString(3, oto.getMauSacNoiThatString());
            ps.setString(4, oto.getXuatXuString());
            ps.setString(5, oto.getDongCoString());
            ps.setString(6, oto.getMoTaString());
            ps.setString(7, String.valueOf(oto.getGiaFloat()));
            ps.setInt(8, oto.getSoGhe());
            ps.setString(9, oto.getTrangThai());
            ps.setString(10, String.valueOf(oto.getChieuDai()));
            ps.setString(11, String.valueOf(oto.getChieuCao()));
            ps.setInt(12, oto.getSoLuong());
            ps.setString(13, oto.getHinhAnh());
            ps.executeUpdate();
            System.out.println("Thêm dữ liệu thành công!");
            check = true;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static ArrayList<Oto> docDuLieu() {
        ArrayList<Oto> dsOto = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM oto";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Oto oto = new Oto();
                oto.setMaXeString(rs.getString("MaXe"));
                oto.setTenXeString(rs.getString("TenXe"));
                oto.setMauSacNoiThatString(rs.getString("MauSacNoiThat"));
                oto.setXuatXuString(rs.getString("XuatXu"));
                oto.setDongCoString(rs.getString("DongCo"));
                oto.setMoTaString(rs.getString("MoTa"));
                oto.setGiaFloat(rs.getFloat("Gia"));
                oto.setSoGhe(rs.getInt("SoGhe"));
                oto.setTrangThai(rs.getString("TrangThai"));
                oto.setChieuDai(rs.getInt("ChieuDai"));
                oto.setChieuCao(rs.getInt("ChieuCao"));
                oto.setSoLuong(rs.getInt("SoLuong"));
                oto.setHinhAnh(rs.getString("HinhAnh"));
                dsOto.add(oto);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return dsOto;
    }

    public static boolean xoaOto(String maXeString) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "DELETE FROM oto WHERE MaXe = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maXeString);
            ps.executeUpdate();
            System.out.println("Xóa dữ liệu thành công!");
            check = true;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static boolean suaOto(Oto oto) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "UPDATE oto SET TenXe = ?, MauSacNoiThat = ?, XuatXu = ?, DongCo = ?, MoTa = ?, Gia = ?, SoGhe = ?, TrangThai = ?, ChieuDai = ?, ChieuCao = ?, SoLuong = ?, HinhAnh = ? WHERE MaXe = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, oto.getTenXeString());
            ps.setString(2, oto.getMauSacNoiThatString());
            ps.setString(3, oto.getXuatXuString());
            ps.setString(4, oto.getDongCoString());
            ps.setString(5, oto.getMoTaString());
            ps.setString(6, String.valueOf(oto.getGiaFloat()));
            ps.setInt(7, oto.getSoGhe());
            ps.setString(8, oto.getTrangThai());
            ps.setInt(9, oto.getChieuDai());
            ps.setInt(10, oto.getChieuCao());
            ps.setInt(11, oto.getSoLuong());
            ps.setString(12, oto.getHinhAnh());
            ps.setString(13, oto.getMaXeString());
            System.out.println(ps.toString()); // In câu lệnh SQL
            int a = ps.executeUpdate();
            System.out.println(a);
            System.out.println("Cập nhật dữ liệu thành công!");
            check = true;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static ArrayList<Oto> timKiemTheoMaXe(String maXe) throws Exception {
        ArrayList<Oto> dsOto = new ArrayList<>();

        String sql = "SELECT * FROM oto WHERE MaXe LIKE '%" + maXe + "%'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Oto oto = new Oto();
            oto.setMaXeString(resultSet.getString("MaXe"));
            oto.setTenXeString(resultSet.getString("TenXe"));
            oto.setMauSacNoiThatString(resultSet.getString("MauSacNoiThat"));
            oto.setXuatXuString(resultSet.getString("XuatXu"));
            oto.setDongCoString(resultSet.getString("DongCo"));
            oto.setMoTaString(resultSet.getString("MoTa"));
            oto.setGiaFloat(resultSet.getFloat("Gia"));
            oto.setSoGhe(resultSet.getInt("SoGhe"));
            oto.setTrangThai(resultSet.getString("TrangThai"));
            oto.setChieuDai(resultSet.getInt("ChieuDai"));
            oto.setChieuCao(resultSet.getInt("ChieuCao"));
            oto.setSoLuong(resultSet.getInt("SoLuong"));
            oto.setHinhAnh(resultSet.getString("HinhAnh"));
            dsOto.add(oto);
        }

        return dsOto;
    }

    public static ArrayList<Oto> timKiemTheoTenXe(String TenXe) throws Exception {
        ArrayList<Oto> dsOto = new ArrayList<>();

        String sql = "SELECT * FROM oto WHERE TenXe LIKE '%" + TenXe + "%'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Oto oto = new Oto();
            oto.setMaXeString(resultSet.getString("MaXe"));
            oto.setTenXeString(resultSet.getString("TenXe"));
            oto.setMauSacNoiThatString(resultSet.getString("MauSacNoiThat"));
            oto.setXuatXuString(resultSet.getString("XuatXu"));
            oto.setDongCoString(resultSet.getString("DongCo"));
            oto.setMoTaString(resultSet.getString("MoTa"));
            oto.setGiaFloat(resultSet.getFloat("Gia"));
            oto.setSoGhe(resultSet.getInt("SoGhe"));
            oto.setTrangThai(resultSet.getString("TrangThai"));
            oto.setChieuDai(resultSet.getInt("ChieuDai"));
            oto.setChieuCao(resultSet.getInt("ChieuCao"));
            oto.setSoLuong(resultSet.getInt("SoLuong"));
            oto.setHinhAnh(resultSet.getString("HinhAnh"));
            dsOto.add(oto);
        }

        return dsOto;
    }
    public static ArrayList<Oto> timKiemTonKho() throws Exception {
        ArrayList<Oto> dsOto = new ArrayList<>();

       String sql = "SELECT * FROM oto WHERE TrangThai = 'Tồn kho'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Oto oto = new Oto();
            oto.setMaXeString(resultSet.getString("MaXe"));
            oto.setTenXeString(resultSet.getString("TenXe"));
            oto.setMauSacNoiThatString(resultSet.getString("MauSacNoiThat"));
            oto.setXuatXuString(resultSet.getString("XuatXu"));
            oto.setDongCoString(resultSet.getString("DongCo"));
            oto.setMoTaString(resultSet.getString("MoTa"));
            oto.setGiaFloat(resultSet.getFloat("Gia"));
            oto.setSoGhe(resultSet.getInt("SoGhe"));
            oto.setTrangThai(resultSet.getString("TrangThai"));
            oto.setChieuDai(resultSet.getInt("ChieuDai"));
            oto.setChieuCao(resultSet.getInt("ChieuCao"));
            oto.setSoLuong(resultSet.getInt("SoLuong"));
            oto.setHinhAnh(resultSet.getString("HinhAnh"));
            dsOto.add(oto);
        }

        return dsOto;
    }
    public static ArrayList<Oto> timKiemChuaThanhToan() throws Exception {
        ArrayList<Oto> dsOto = new ArrayList<>();

       String sql = "SELECT * FROM oto WHERE TrangThai = 'Đợi thanh toán'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Oto oto = new Oto();
            oto.setMaXeString(resultSet.getString("MaXe"));
            oto.setTenXeString(resultSet.getString("TenXe"));
            oto.setMauSacNoiThatString(resultSet.getString("MauSacNoiThat"));
            oto.setXuatXuString(resultSet.getString("XuatXu"));
            oto.setDongCoString(resultSet.getString("DongCo"));
            oto.setMoTaString(resultSet.getString("MoTa"));
            oto.setGiaFloat(resultSet.getFloat("Gia"));
            oto.setSoGhe(resultSet.getInt("SoGhe"));
            oto.setTrangThai(resultSet.getString("TrangThai"));
            oto.setChieuDai(resultSet.getInt("ChieuDai"));
            oto.setChieuCao(resultSet.getInt("ChieuCao"));
            oto.setSoLuong(resultSet.getInt("SoLuong"));
            oto.setHinhAnh(resultSet.getString("HinhAnh"));
            dsOto.add(oto);
        }

        return dsOto;
    }

    public static ArrayList<Oto> timKiemTheoXuatXu(String XuatXu) throws Exception {
        ArrayList<Oto> dsOto = new ArrayList<>();

        String sql = "SELECT * FROM oto WHERE XuatXu LIKE '%" + XuatXu + "%'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Oto oto = new Oto();
            oto.setMaXeString(resultSet.getString("MaXe"));
            oto.setTenXeString(resultSet.getString("TenXe"));
            oto.setMauSacNoiThatString(resultSet.getString("MauSacNoiThat"));
            oto.setXuatXuString(resultSet.getString("XuatXu"));
            oto.setDongCoString(resultSet.getString("DongCo"));
            oto.setMoTaString(resultSet.getString("MoTa"));
            oto.setGiaFloat(resultSet.getFloat("Gia"));
            oto.setSoGhe(resultSet.getInt("SoGhe"));
            oto.setTrangThai(resultSet.getString("TrangThai"));
            oto.setChieuDai(resultSet.getInt("ChieuDai"));
            oto.setChieuCao(resultSet.getInt("ChieuCao"));
            oto.setSoLuong(resultSet.getInt("SoLuong"));
            oto.setHinhAnh(resultSet.getString("HinhAnh"));
            dsOto.add(oto);
        }

        return dsOto;
    }

    public static ArrayList<Oto> SapXepOto() {
        ArrayList<Oto> arrM = docDuLieu();
        Collections.sort(arrM, new Comparator<Oto>() {
            @Override
            public int compare(Oto o1, Oto o2) {
                return o1.getMaXeString().compareTo(o2.getMaXeString());
            }
        });
        return arrM;
    }

    public static ArrayList<Oto> SapXepTenOto() {
        ArrayList<Oto> arrM = docDuLieu();
        Collections.sort(arrM, new Comparator<Oto>() {
            @Override
            public int compare(Oto o1, Oto o2) {
                return o1.getTenXeString().compareTo(o2.getTenXeString());
            }
        });
        return arrM;
    }

    public static ArrayList<Oto> SapXepTheoGiaBan() {
        ArrayList<Oto> arrM = docDuLieu();
        Collections.sort(arrM, new Comparator<Oto>() {
            @Override
            public int compare(Oto o1, Oto o2) {
                if(o1.getGiaFloat() == o2.getGiaFloat()){
                    return 0;
                }
                else if(o1.getGiaFloat()>o2.getGiaFloat()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        return arrM;
    }

    public static ArrayList<Oto> SapXepTheoSoLuong() {
        ArrayList<Oto> arrM = docDuLieu();
        Collections.sort(arrM, new SapXepTheoSoLuong());
        return arrM;
    }
}
