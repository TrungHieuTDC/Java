/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.GiaoDich;
import Model.QuanLyGiaoDichModel;
import View.frmBaoCao;
import View.frmGiaoDich;
import View.frmInHoaDon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class BaoCao_Controller {
    private QuanLyGiaoDichModel model;
    private frmBaoCao view;
    DefaultTableModel tbmodel;

    public BaoCao_Controller(QuanLyGiaoDichModel model, frmBaoCao view) throws Exception {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        frmGiaoDich viewGD = new frmGiaoDich();
        loadTableGiaoDich();
        view.getjButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    view.dispose();
                QuanLyGiaoDich_Controller ql = new QuanLyGiaoDich_Controller(model, viewGD);
                } catch (Exception ex) {
                    
                }
                
            }
        });
        
    }
    private void loadTableGiaoDich() throws Exception {

        tbmodel = (DefaultTableModel) view.getTblHD().getModel();
        tbmodel.getDataVector().removeAllElements();
        tbmodel.setColumnIdentifiers(new Object[]{
            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
        });
        for (GiaoDich giaoDich : model.inDanhSach()) {
            tbmodel.addRow(new Object[]{
                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
            });
        }
    }
    
}
