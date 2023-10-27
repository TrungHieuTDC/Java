/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.DangNhap_Controller;
import Model.QuanLyOtoModel;
import View.frmDangNhap;
import View.frmOto;

/**
 *
 * @author PC
 */
public class MainChayBai {
     public static void main(String[] args) throws Exception {
        frmOto view = new frmOto();
        frmDangNhap dangNhapView = new frmDangNhap();
        QuanLyOtoModel model = new QuanLyOtoModel();
        DangNhap_Controller ql = new DangNhap_Controller(dangNhapView, model);
       
    }
}
