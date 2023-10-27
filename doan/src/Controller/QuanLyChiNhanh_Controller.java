/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.GiaoDich;
import Model.QuanLyChiNhanhModel;
import Model.QuanLyGiaoDichModel;
import View.frmChiNhanh;
import View.frmInHoaDon;
import Class.ChiNhanh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class QuanLyChiNhanh_Controller {
    private QuanLyChiNhanhModel model;
    private frmChiNhanh view;
    DefaultTableModel tbmodel;

    public QuanLyChiNhanh_Controller(QuanLyChiNhanhModel model, frmChiNhanh view) throws Exception {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        loadTableChiNhanh();
        view.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }
    private void loadTableChiNhanh() throws Exception {

        tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
        tbmodel.getDataVector().removeAllElements();
        tbmodel.setColumnIdentifiers(new Object[]{
            "Tên chi nhánh", "Địa chỉ", "Quản lý"
        });
        for (ChiNhanh cn : model.docDuLieuChiNhanh()) {
            tbmodel.addRow(new Object[]{
                cn.getTenChiNhanhString(), cn.getDiaChiString(), cn.getMaNVQL()
            });
        }
    }
    
    
}
