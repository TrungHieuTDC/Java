/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Class.Oto;
import Model.QuanLyChiNhanhModel;
import Model.QuanLyGiaoDichModel;
import View.frmOto;
import Model.QuanLyOtoModel;
import View.frmChiNhanh;
import View.frmGiaoDich;
import View.frmSuaThongTinXe;
import View.frmThemXe;
import View.frmXoaXe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyOto_Controller {
    private QuanLyOtoModel model;
    private frmOto view;
    DefaultTableModel tbmodel;
    public QuanLyOto_Controller(QuanLyOtoModel model, frmOto view) throws Exception{
        this.model = model;
        this.view = view;
        frmThemXe viewThem = new frmThemXe();
        frmXoaXe viewXoa = new frmXoaXe();
        frmSuaThongTinXe viewSua = new frmSuaThongTinXe();
        ButtonGroup bg = new ButtonGroup();
        bg.add(view.getRdoHangTonKho());
        bg.add(view.getRdoDoiThanhToan());
        bg.add(view.getRdoTheoMaXe());
        bg.add(view.getRdoTheoGiaBan());
        bg.add(view.getRdoTheoSoLuong());
        bg.add(view.getRdoTheoTenXe());
        view.setVisible(true);
        loadTableOto();
        view.getBtnThemXe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        view.dispose();              
                       QuanLyThemOto_Controller themview = new QuanLyThemOto_Controller(model, viewThem);
                } catch (Exception ex) {   
                }
            }
        });
        view.getBtnXoaXe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        view.dispose();              
                       QuanLyXoaOto_Controller xoaview = new QuanLyXoaOto_Controller(model, viewXoa);
                } catch (Exception ex) {   
                }
            }
        });
         view.getBtnSuaThongTinXe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        view.dispose();              
                       QuanLySuaOto_Controller suaview = new QuanLySuaOto_Controller(model, viewSua);
                } catch (Exception ex) {   
                }
            }
        });
         view.getTxtMaXe().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                view.getTxtTheoTenXe().setEnabled(false);  
                view.getTxtXuatXu().setEnabled(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
               view.getTxtTheoTenXe().setEnabled(true);     
               view.getTxtXuatXu().setEnabled(true);
            }
         });
         view.getTxtTheoTenXe().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                view.getTxtMaXe().setEnabled(false);
                view.getTxtXuatXu().setEnabled(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                view.getTxtMaXe().setEnabled(true);      
                view.getTxtXuatXu().setEnabled(true);
            }
         });
         view.getTxtXuatXu().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                view.getTxtMaXe().setEnabled(false); 
                view.getTxtTheoTenXe().setEnabled(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                view.getTxtMaXe().setEnabled(true);    
                view.getTxtTheoTenXe().setEnabled(true);
            }
         });
         view.getBtnLamMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loadTableOto();
                } catch (Exception ex) {
                }
            }
         });
         view.getBtnTimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        String fieldToSearch = "";
                        if (!view.getTxtMaXe().getText().isEmpty()) {
                             fieldToSearch = "MaXe";
                        } else if (!view.getTxtTheoTenXe().getText().isEmpty()) {
                             fieldToSearch = "TenXe";
                        } else if (!view.getTxtXuatXu().getText().isEmpty()) {
                             fieldToSearch = "XuatXu";
                        }
                        if (!fieldToSearch.isEmpty()) {
                            if (fieldToSearch.equals("MaXe")) {
                                ArrayList<Oto> arrM = model.timKiemTheoMaXe(view.getTxtMaXe().getText());
                                tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                                tbmodel.getDataVector().removeAllElements();
                                tbmodel.setColumnIdentifiers(new Object[]{
                                "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                            for (Oto oto : arrM) {
                                tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                            }
                        }else if(fieldToSearch.equals("TenXe"))
                        {
                            ArrayList<Oto> arrM = model.timKiemTheoTenXe(view.getTxtTheoTenXe().getText());
                                tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                                tbmodel.getDataVector().removeAllElements();
                                tbmodel.setColumnIdentifiers(new Object[]{
                                "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                            for (Oto oto : arrM) {
                                tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                            }
                        }
                        else if(fieldToSearch.equals("XuatXu")){
                            ArrayList<Oto> arrM = model.timKiemTheoXuatXu(view.getTxtXuatXu().getText());
                                tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                                tbmodel.getDataVector().removeAllElements();
                                tbmodel.setColumnIdentifiers(new Object[]{
                                "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                            for (Oto oto : arrM) {
                                tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                            }
                        }   
                        view.getTxtMaXe().setText("");
                        view.getTxtTheoTenXe().setText("");
                        view.getTxtXuatXu().setText("");
                   }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Mã không tồn tại");
                }
            }
         });
         view.getRdoTheoGiaBan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Oto> arrM = model.sapXepTheoGiaBan();
                    if(view.getRdoTheoGiaBan().isSelected())
                    {
                        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                        for (Oto oto : arrM) {
                            tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                        }
                         System.out.println("theo gia");
                    }          
                } catch (Exception ex) {
                }
            }
         });
         view.getRdoTheoSoLuong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Oto> arrM = model.sapXepTheoSoLuong();
                    if(view.getRdoTheoSoLuong().isSelected())
                    {
                        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                        for (Oto oto : arrM) {
                            tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                        }
                         System.out.println("theo sl");
                    }          
                } catch (Exception ex) {
                }
            }
         });
         view.getRdoTheoMaXe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Oto> arrM = model.sapXepTheoMa();
                    if(view.getRdoTheoMaXe().isSelected())
                    {
                        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                        for (Oto oto : arrM) {
                            tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                        }
                        System.out.println("theo ma");
                    }          
                } catch (Exception ex) {
                }
            }
         });
         view.getRdoTheoTenXe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Oto> arrM = model.sapXepTheoTen();
                    if(view.getRdoTheoTenXe().isSelected())
                    {
                        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                        for (Oto oto : arrM) {
                            tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                        }
                         System.out.println("theo ten");
                    }          
                } catch (Exception ex) {
                }
            }
         });
         view.getRdoHangTonKho().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Oto> arrM = model.timKiemHangTonKho();
                    if(view.getRdoHangTonKho().isSelected())
                    {
                        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                        for (Oto oto : arrM) {
                            tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                        }
                         System.out.println("theo gia");
                    }          
                } catch (Exception ex) {
                }
            }
         });
         view.getRdoDoiThanhToan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Oto> arrM = model.timKiemChuaThanhToan();
                    if(view.getRdoDoiThanhToan().isSelected())
                    {
                        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
                        tbmodel.getDataVector().removeAllElements();
                        tbmodel.setColumnIdentifiers(new Object[]{
                            "Mã xe", "Tên xe", "Màu nội thất", "Xuất xứ", "Động cơ", "Mô tả", "Giá", "Số ghế", "Trạng thái", "Chiều dài", "Chiều cao", "Số lượng", "Hình ảnh"
                        });
                        for (Oto oto : arrM) {
                            tbmodel.addRow(new Object[]{
                                oto.getMaXeString(),oto.getTenXeString(),oto.getMauSacNoiThatString(),oto.getXuatXuString(),oto.getDongCoString(), oto.getMoTaString(),String.valueOf(oto.getGiaFloat()),String.valueOf(oto.getSoGhe()), oto.getTrangThai(),String.valueOf(oto.getChieuDai()),String.valueOf(oto.getChieuCao()),String.valueOf(oto.getSoLuong()),oto.getHinhAnh()
                            });
                        }
                         System.out.println("theo gia");
                    }          
                } catch (Exception ex) {
                }
            }
         });
         view.getBtnGiaoDich().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 frmGiaoDich giaoDich = new frmGiaoDich();
                 QuanLyGiaoDichModel modelGD = new QuanLyGiaoDichModel();
                try {
                    view.dispose();
                    QuanLyGiaoDich_Controller GiaoDichController = new QuanLyGiaoDich_Controller(modelGD, giaoDich);
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
    private void loadTableOto() throws Exception {

        tbmodel = (DefaultTableModel) view.getTblDanhSachOTo().getModel();
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
 
    public QuanLyOtoModel getModel() {
        return model;
    }

    public void setModel(QuanLyOtoModel model) {
        this.model = model;
    }

    public frmOto getView() {
        return view;
    }

    public void setView(frmOto view) {
        this.view = view;
    }
    
}
