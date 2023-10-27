/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.QuanLyOtoModel;
import View.frmDangNhap;
import View.frmDangNhapQuanLy;
import View.frmOto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class DangNhapQuanly_Controller {
    private frmDangNhapQuanLy view;
    private Model.QuanLyOtoModel model;
    
    
    public DangNhapQuanly_Controller(frmDangNhapQuanLy view, QuanLyOtoModel model) {
        this.view = view;
        this.model = model;
        frmDangNhap viewDangNhap = new frmDangNhap();
        view.setVisible(true);
        frmOto viewOto = new frmOto();
        view.getBtnDangNhap().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                if(!view.getTxtMaNV().getText().isEmpty() && !view.getPwMatKhau().getText().isEmpty()){
                    boolean check = model.kiemTraDangNhap(view.getTxtMaNV().getText(), view.getPwMatKhau().getText());  
                    if(check){
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công !!!");
                        view.dispose();
                        QuanLyOto_Controller qlOto = new QuanLyOto_Controller(model, viewOto);
                    }else{
                        JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại mã nhân viên và mật khẩu");
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!!");
                }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại mã nhân viên và mật khẩu");
                }
            }
        });
        view.getBtnQuayLai().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                DangNhap_Controller dangnhap = new DangNhap_Controller(viewDangNhap, model);
            }
        });
    }
    
}
