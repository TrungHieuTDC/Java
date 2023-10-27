/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.Oto;
import Model.QuanLyOtoModel;
import View.frmOto;
import View.frmSuaThongTinXe;
import View.frmSuaThongTinXeChiTiet;
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
public class QuanLySuaOto_Controller {
    private QuanLyOtoModel model;
    private frmSuaThongTinXe view;
    DefaultTableModel tbmodel;

    public QuanLySuaOto_Controller(QuanLyOtoModel model, frmSuaThongTinXe view) throws Exception{
        this.model = model;
        this.view = view;
        view.setVisible(true);
        frmOto viewOto = new frmOto();
        frmSuaThongTinXeChiTiet viewSuaChiTiet = new frmSuaThongTinXeChiTiet();
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
                    int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa Otô có mã xe đang chọn không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {       
                        view.getTxtMaXe().setText("");
                        QuanLySuaOtoChiTiet_Controller suaChiTiet = new QuanLySuaOtoChiTiet_Controller(model, viewSuaChiTiet, maOto);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Bạn chưa chọn otô cần sửa!!!");
                }
                
            }
        });
        view.getTblDSSua().addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            int row = view.getTblDSSua().getSelectedRow();
            String maXe = (String) tbmodel.getValueAt(row, 0);
            view.getTxtMaXe().setText(maXe);
        }
        });
    }
    //lay danh sach load len table
    private void loadTableOto() throws Exception {

        tbmodel = (DefaultTableModel) view.getTblDSSua().getModel();
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
