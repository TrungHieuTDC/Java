/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import static Class.QuanLyGiaoDich.getConnection;
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
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class QuanLyChiNhanh {
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
    public static ArrayList<ChiNhanh> docDuLieu() {
        ArrayList<ChiNhanh> dsChiNhanh = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM chinhanh";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiNhanh chiNhanh = new ChiNhanh();
                chiNhanh.setTenChiNhanhString(rs.getString("TenChiNhanh"));
                chiNhanh.setDiaChiString(rs.getString("DiaChi"));
                chiNhanh.setMaNVQL(rs.getString("NhanVienQuanLy"));    
                dsChiNhanh.add(chiNhanh);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return dsChiNhanh;
    }
}
