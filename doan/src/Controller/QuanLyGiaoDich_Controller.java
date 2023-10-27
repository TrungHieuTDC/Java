/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.GiaoDich;
import Class.Oto;
import Model.QuanLyChiNhanhModel;
import Model.QuanLyGiaoDichModel;
import Model.QuanLyOtoModel;
import View.frmBaoCao;
import View.frmChiNhanh;
import View.frmGiaoDich;
import View.frmInHoaDon;
import View.frmOto;
import View.frmSuaThongTinXe;
import View.frmThemXe;
import View.frmXoaXe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class QuanLyGiaoDich_Controller {

    private QuanLyGiaoDichModel model;
    private frmGiaoDich view;
    DefaultTableModel tbmodel;

    public QuanLyGiaoDich_Controller(QuanLyGiaoDichModel model, frmGiaoDich view) throws Exception {
        this.model = model;
        this.view = view;
        frmThemXe viewThem = new frmThemXe();
        frmXoaXe viewXoa = new frmXoaXe();
        frmSuaThongTinXe viewSua = new frmSuaThongTinXe();
        ButtonGroup bg = new ButtonGroup();
        bg.add(view.getRdoTheoTenKH());
        bg.add(view.getRdoTheoThoiGian());
        bg.add(view.getRdoTheoMaHD());
        bg.add(view.getRdoTheoNVBan());
        bg.add(view.getRdoChuaGiaoHang());
        bg.add(view.getRdoDangGiaoHang());
        bg.add(view.getRdoDaHoanThanh());
        view.setVisible(true);
        loadTableGiaoDich();

        view.getBtnLamMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loadTableGiaoDich();
                } catch (Exception ex) {
                }
            }
        });
        view.getBtnTimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<GiaoDich> arrM = model.timKiemGiaoDich(view.getTxtThongTin_TimKiem().getText());
                    
                   tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    view.getTxtThongTin_TimKiem().setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Mã không tồn tại");
                }
            }
        });
        view.getRdoChuaGiaoHang().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<GiaoDich> arrM = model.timKiemChuaGiaoHang();
                    if (view.getRdoChuaGiaoHang().isSelected()) {
                       tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getRdoDangGiaoHang().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<GiaoDich> arrM = model.timKiemDangGiaoHang();
                    if (view.getRdoDangGiaoHang().isSelected()) {
                       tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getRdoDaHoanThanh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<GiaoDich> arrM = model.timKiemĐaHoanThanh();
                    if (view.getRdoDaHoanThanh().isSelected()) {
                       tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getBtnInHoaDon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmInHoaDon hd = new frmInHoaDon();
                try {
                    InHoaDon_Controller inHoaDon = new InHoaDon_Controller(model, hd);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyGiaoDich_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        view.getRdoTheoMaHD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    if (view.getRdoTheoMaHD().isSelected()) {
                        ArrayList<GiaoDich> arrM = model.SapXepTheoMa();
                        System.out.println("ma");
                        tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getRdoTheoNVBan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {     
                    if (view.getRdoTheoNVBan().isSelected()) {
                        ArrayList<GiaoDich> arrM = model.SapXepTheoTenNhanVien();
                        System.out.println("nv");
                        tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(),giaoDich.getThoiGian(),giaoDich.getKhachHang(),giaoDich.getNhanVien(),giaoDich.getTrangThai(),String.valueOf(giaoDich.getGiaBan()),String.valueOf(giaoDich.getSoLuong()),giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getRdoTheoTenKH().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<GiaoDich> arrM = model.SapXepTheoTenKhachHang();
                    if (view.getRdoTheoTenKH().isSelected()) {
                        System.out.println("tenkh");
                        tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getRdoTheoThoiGian().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<GiaoDich> arrM = model.SapXepTheoThoiGian();
                    if (view.getRdoTheoThoiGian().isSelected()) {
                        System.out.println("thoigian");
                        tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã giao dịch", "Thời gian", "Khách hàng", "Nhân viên", "Trạng thái", "Giá bán", "Số lượng", "Oto"
                        });
                        for (GiaoDich giaoDich : arrM) {
                            tbmodel.addRow(new Object[]{
                                giaoDich.getMaGiaoDich(), giaoDich.getThoiGian(), giaoDich.getKhachHang(), giaoDich.getNhanVien(), giaoDich.getTrangThai(), String.valueOf(giaoDich.getGiaBan()), String.valueOf(giaoDich.getSoLuong()), giaoDich.getOto()
                            });
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        view.getBtnBaoCao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 frmBaoCao hd = new frmBaoCao();
                try {
                    BaoCao_Controller inHoaDon = new BaoCao_Controller(model, hd);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyGiaoDich_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        view.getBtnOto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 frmOto oto = new frmOto();
                 QuanLyOtoModel modelOto = new QuanLyOtoModel();
                try {
                    view.dispose();
                    QuanLyOto_Controller inHoaDon = new QuanLyOto_Controller(modelOto, oto);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyGiaoDich_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
         view.getBtnChiNhanh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 frmChiNhanh chiNhanh = new frmChiNhanh();
                 QuanLyChiNhanhModel modelCN = new QuanLyChiNhanhModel();
                try {
                    QuanLyChiNhanh_Controller cn = new QuanLyChiNhanh_Controller(modelCN, chiNhanh);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyOto_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    //lay danh sach load len table
    private void loadTableGiaoDich() throws Exception {

        tbmodel = (DefaultTableModel) view.getTblThongTin().getModel();
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
