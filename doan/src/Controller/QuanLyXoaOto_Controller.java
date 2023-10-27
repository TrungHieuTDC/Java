/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.Oto;
import Model.QuanLyOtoModel;
import View.frmOto;
import View.frmXoaXe;
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
public class QuanLyXoaOto_Controller {
    private QuanLyOtoModel model;
    private frmXoaXe view;
    DefaultTableModel tbmodel;

    public QuanLyXoaOto_Controller(QuanLyOtoModel model, frmXoaXe view) throws Exception{
        this.model = model;
        this.view = view;
        view.setVisible(true);
        frmOto viewOto = new frmOto();
       loadTableOto();
        view.getBtnThoat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    view.dispose();
                    new frmOto().setVisible(true);
                QuanLyOto_Controller ql = new QuanLyOto_Controller(model, viewOto);
                } catch (Exception ex) {
                    
                }
                
            }
        });
         view.getBtnXacNhan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                    
                    String maOto = view.getTxtMaXe().getText();

                    int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa Otô có mã xe đang chọn không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        model.xoaOto(maOto);
                        JOptionPane.showMessageDialog(null, "Xóa Thành Công");            
                        view.getTxtMaXe().setText("");
                        loadTableOto();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn otô cần xóa!!!");
                }
                
            }
        });
        view.getTblDanhSachXoaXe().addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            int row = view.getTblDanhSachXoaXe().getSelectedRow();
            String maXe = (String) tbmodel.getValueAt(row, 0);
            view.getTxtMaXe().setText(maXe);
        }
        });
    }
    //lay danh sach load len table
    private void loadTableOto() throws Exception {

        tbmodel = (DefaultTableModel) view.getTblDanhSachXoaXe().getModel();
        tbmodel.getDataVector().removeAllElements();
        tbmodel.setColumnIdentifiers(new Object[]{
            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
        });
        for (Oto oto : model.danhSachOto()) {
            tbmodel.addRow(new Object[]{
                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
            });
        }
    }
}
