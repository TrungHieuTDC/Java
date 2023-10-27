/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import static Class.QuanLyOTo.getConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author PC
 */
public class QuanLyGiaoDich {

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

    public static boolean themGiaoDich(GiaoDich giaoDich) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "INSERT INTO giaodich (thoiGian, khachHang, nhanVien, trangThai, giaBan, soLuong, oto) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, giaoDich.getThoiGian());
            ps.setString(2, giaoDich.getKhachHang());
            ps.setString(3, giaoDich.getNhanVien());
            ps.setString(4, giaoDich.getTrangThai());
            ps.setDouble(5, giaoDich.getGiaBan());
            ps.setInt(6, giaoDich.getSoLuong());
            ps.setString(7, giaoDich.getOto());
            ps.executeUpdate();
            System.out.println("Thêm dữ liệu thành công!");
            check = true;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static ArrayList<GiaoDich> docDuLieu() {
        ArrayList<GiaoDich> dsGiaoDich = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM giaodich";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiaoDich giaoDich = new GiaoDich();
                giaoDich.setMaGiaoDich(rs.getString("MaGiaoDich"));
                giaoDich.setThoiGian(rs.getString("ThoiGian"));
                giaoDich.setKhachHang(rs.getString("TenKhachHang"));
                giaoDich.setNhanVien(rs.getString("TenNhanVien"));
                giaoDich.setTrangThai(rs.getString("TrangThai"));
                giaoDich.setGiaBan(rs.getDouble("GiaBan"));
                giaoDich.setSoLuong(rs.getInt("SoLuong"));
                giaoDich.setOto(rs.getString("TenOto"));
                dsGiaoDich.add(giaoDich);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> timKiem(String tuKhoa) throws Exception {
        ArrayList<GiaoDich> dsGiaoDich = new ArrayList<>();

        String sql = "SELECT * FROM giaodich WHERE MaGiaoDich LIKE '%" + tuKhoa + "%' OR TenKhachHang LIKE '%" + tuKhoa + "%' OR TenNhanVien LIKE '%" + tuKhoa + "%' OR TenOto LIKE '%" + tuKhoa + "%'";
        Connection conn = QuanLyOTo.getConnection();
        System.out.println(sql);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            GiaoDich giaoDich = new GiaoDich();
            giaoDich.setMaGiaoDich(resultSet.getString("MaGiaoDich"));
            giaoDich.setThoiGian(resultSet.getString("ThoiGian"));
            giaoDich.setKhachHang(resultSet.getString("TenKhachHang"));
            giaoDich.setNhanVien(resultSet.getString("TenNhanVien"));
            giaoDich.setTrangThai(resultSet.getString("TrangThai"));
            giaoDich.setGiaBan(resultSet.getDouble("GiaBan"));
            giaoDich.setSoLuong(resultSet.getInt("SoLuong"));
            giaoDich.setOto(resultSet.getString("TenOto"));
            dsGiaoDich.add(giaoDich);
        }

        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> timKiemDangGiaoHang() throws Exception {
        ArrayList<GiaoDich> dsGiaoDich = new ArrayList<>();

        String sql = "SELECT * FROM giaodich WHERE TrangThai = 'Đang giao hàng'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            GiaoDich giaoDich = new GiaoDich();
            giaoDich.setMaGiaoDich(resultSet.getString("MaGiaoDich"));
            giaoDich.setThoiGian(resultSet.getString("ThoiGian"));
            giaoDich.setKhachHang(resultSet.getString("TenKhachHang"));
            giaoDich.setNhanVien(resultSet.getString("TenNhanVien"));
            giaoDich.setTrangThai(resultSet.getString("TrangThai"));
            giaoDich.setGiaBan(resultSet.getDouble("GiaBan"));
            giaoDich.setSoLuong(resultSet.getInt("SoLuong"));
            giaoDich.setOto(resultSet.getString("TenOto"));
            dsGiaoDich.add(giaoDich);
        }

        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> timKiemChuaGiaoHang() throws Exception {
        ArrayList<GiaoDich> dsGiaoDich = new ArrayList<>();

        String sql = "SELECT * FROM giaodich WHERE TrangThai = 'Chưa giao hàng'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            GiaoDich giaoDich = new GiaoDich();
            giaoDich.setMaGiaoDich(resultSet.getString("MaGiaoDich"));
            giaoDich.setThoiGian(resultSet.getString("ThoiGian"));
            giaoDich.setKhachHang(resultSet.getString("TenKhachHang"));
            giaoDich.setNhanVien(resultSet.getString("TenNhanVien"));
            giaoDich.setTrangThai(resultSet.getString("TrangThai"));
            giaoDich.setGiaBan(resultSet.getDouble("GiaBan"));
            giaoDich.setSoLuong(resultSet.getInt("SoLuong"));
            giaoDich.setOto(resultSet.getString("TenOto"));
            dsGiaoDich.add(giaoDich);
        }

        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> timKiemĐaHoanThanh() throws Exception {
        ArrayList<GiaoDich> dsGiaoDich = new ArrayList<>();

        String sql = "SELECT * FROM giaodich WHERE TrangThai = 'Đã hoàn thành'";
        Connection conn = QuanLyOTo.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            GiaoDich giaoDich = new GiaoDich();
            giaoDich.setMaGiaoDich(resultSet.getString("MaGiaoDich"));
            giaoDich.setThoiGian(resultSet.getString("ThoiGian"));
            giaoDich.setKhachHang(resultSet.getString("TenKhachHang"));
            giaoDich.setNhanVien(resultSet.getString("TenNhanVien"));
            giaoDich.setTrangThai(resultSet.getString("TrangThai"));
            giaoDich.setGiaBan(resultSet.getDouble("GiaBan"));
            giaoDich.setSoLuong(resultSet.getInt("SoLuong"));
            giaoDich.setOto(resultSet.getString("TenOto"));
            dsGiaoDich.add(giaoDich);
        }

        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> SapXepTheoMa() {
        ArrayList<GiaoDich> dsGiaoDich = docDuLieu();
        Collections.sort(dsGiaoDich, new Comparator<GiaoDich>() {
            @Override
            public int compare(GiaoDich g1, GiaoDich g2) {
                return g1.getMaGiaoDich().compareTo(g2.getMaGiaoDich());
            }
        });
        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> SapXepTheoThoiGian() {
        ArrayList<GiaoDich> dsGiaoDich = docDuLieu();
        Collections.sort(dsGiaoDich, new Comparator<GiaoDich>() {
            @Override
            public int compare(GiaoDich g1, GiaoDich g2) {
                return g1.getThoiGian().compareTo(g2.getThoiGian());
            }
        });
        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> SapXepTheoTenKhachHang() {
        ArrayList<GiaoDich> dsGiaoDich = docDuLieu();
        Collections.sort(dsGiaoDich, new Comparator<GiaoDich>() {
            @Override
            public int compare(GiaoDich g1, GiaoDich g2) {
                return g1.getKhachHang().compareTo(g2.getKhachHang());
            }
        });
        return dsGiaoDich;
    }

    public static ArrayList<GiaoDich> SapXepTheoTenNhanVien() {
        ArrayList<GiaoDich> dsGiaoDich = docDuLieu();
        Collections.sort(dsGiaoDich, new Comparator<GiaoDich>() {
            @Override
            public int compare(GiaoDich g1, GiaoDich g2) {
                return g1.getNhanVien().compareTo(g2.getNhanVien());
            }
        });
        return dsGiaoDich;
    }

}
