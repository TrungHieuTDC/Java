/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.GiaoDich;
import Model.QuanLyGiaoDichModel;
import View.frmGiaoDich;
import View.frmInHoaDon;
import View.frmOto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class InHoaDon_Controller {
    private QuanLyGiaoDichModel model;
    private frmInHoaDon view;
    DefaultTableModel tbmodel;

    public InHoaDon_Controller(QuanLyGiaoDichModel model, frmInHoaDon view) throws Exception {
        this.model = model;
        this.view = view;
        frmGiaoDich viewGD = new frmGiaoDich();
        view.setVisible(true);
        loadTableGiaoDich();
        view.getBtnThoat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    view.dispose();
                QuanLyGiaoDich_Controller ql = new QuanLyGiaoDich_Controller(model, viewGD);
                } catch (Exception ex) {
                    
                }
                
            }
        });
         view.getBtnXuatHD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                    
                    String maHD = view.getTxtMaHD().getText();

                    int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xuất hóa đơn đang chọn không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        
                        JOptionPane.showMessageDialog(null, "Xuất Thành Công");            
                        
                        loadTableGiaoDich();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn otô cần xóa!!!");
                }
                
            }
        });
        view.getjTable1().addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            int row = view.getjTable1().getSelectedRow();
            String maHD = (String) tbmodel.getValueAt(row, 0);
            view.getTxtMaHD().setText(maHD);
        }
        });
    }
    private void loadTableGiaoDich() throws Exception {

        tbmodel = (DefaultTableModel) view.getjTable1().getModel();
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
