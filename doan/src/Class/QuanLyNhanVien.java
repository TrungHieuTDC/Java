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
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author hp
 */
public class QuanLyNhanVien {

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
    public static boolean kiemTraDangNhap(String maNV, String matKhau){
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM users WHERE maNV = ? AND matKhau = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maNV);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();       
            // Kiểm tra kết quả trả về
            if (rs.next()) {
                // User hợp lệ, đăng nhập thành công
                check = true;
            } else {
                // User không tồn tại hoặc mật khẩu không đúng
                check = false;
            }
        } catch (Exception e) {
             System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }
    
}
