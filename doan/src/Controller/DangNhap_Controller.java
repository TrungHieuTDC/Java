/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.QuanLyOtoModel;
import View.frmDangNhap;
import View.frmDangNhapQuanLy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class DangNhap_Controller {
    private frmDangNhap view;
    private Model.QuanLyOtoModel model;

    public DangNhap_Controller(frmDangNhap view, QuanLyOtoModel model) {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        frmDangNhapQuanLy qlView = new frmDangNhapQuanLy();
        view.getBtnQuanLy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                DangNhapQuanly_Controller qlController = new DangNhapQuanly_Controller(qlView,model);
            }
        });
    }
    
}
