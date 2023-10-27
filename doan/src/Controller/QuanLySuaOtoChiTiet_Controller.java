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
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class QuanLySuaOtoChiTiet_Controller {
    private QuanLyOtoModel model;
    private frmSuaThongTinXeChiTiet view;
    private String maOto;
    DefaultTableModel tbmodel;

    public QuanLySuaOtoChiTiet_Controller(QuanLyOtoModel model, frmSuaThongTinXeChiTiet view, String maOto) throws Exception{
        this.model = model;
        this.view = view;
        this.maOto = maOto;
        System.out.println(this.maOto);
        view.setVisible(true);
        frmOto viewOto = new frmOto();
        frmSuaThongTinXe viewSua = new frmSuaThongTinXe();
        CapNhatDuLieu();
        view.getBtnCapNhat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                    if (check_Value() == false) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                    } else {
                        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa dữ liệu?", "Xác nhận sửa dữ liệu", JOptionPane.YES_NO_OPTION);
                        if (confirmResult == JOptionPane.YES_OPTION) {
                            String maOto = view.getLblMaXe().getText();
                            String tenOto = view.getTxtTenXe().getText();
                            String mauOto = view.getTxtMauNoiThat().getText();
                            String xuatXu = view.getTxtXuatXu().getText();
                            String dongCo = view.getTxtDongCo().getText();
                            String moTa = view.getTxtMoTa().getText();
                            float gia = Float.parseFloat(view.getTxtGia().getText());
                            int soGhe = Integer.parseInt(view.getTxtSoGhe().getText());
                            String trangThai = view.getTxtTrangThai().getText();
                            int chieuDai = Integer.parseInt(view.getTxtChieuDai().getText());
                            int chieuCao = Integer.parseInt(view.getTxtChieuCao().getText());
                            int soLuong = Integer.parseInt(view.getTxtSoLuong().getText());
                            String hinhAnh = view.getjLabel19().getText();
                            Oto oto = new Oto(maOto, tenOto, mauOto, xuatXu, dongCo, moTa, gia, soGhe, trangThai, chieuDai, chieuCao, soLuong, hinhAnh);
                            System.out.println(oto.toString());
                            boolean kq = model.suaOto(oto);
                            System.out.println(kq);
                            if (kq) {
                                JOptionPane.showMessageDialog(null, "Sửa otô thành công");
                                 view.dispose();                          
                                 QuanLySuaOto_Controller ql = new QuanLySuaOto_Controller(model, viewSua);
                            }
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex + " Thêm thất bại");
                }
            }
        });
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
        view.getBtnHinh().addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent e) {
               try {
                   JFileChooser f = new JFileChooser();
                   f.setDialogTitle("Mo file");
                   f.showOpenDialog(null);
                   File file = f.getSelectedFile();
                   String filePath = file.getAbsolutePath();
                   BufferedImage buff = new BufferedImage(150, 100, BufferedImage.TYPE_INT_ARGB);
                   buff = ImageIO.read(file);
                   System.out.println(f.toString());
                   ImageIcon icon = new ImageIcon(buff);
                   Image img = icon.getImage();
                   Image imgg = img.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
                   ImageIcon imgcon = new ImageIcon(imgg);
                   view.getjLabel19().setIcon(imgcon);

                   // Gán giá trị mới vào jLabel15
                   view.getjLabel19().setText(filePath);

               } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, "Ban chua chon anh");
               }
           }
       });
    } 
     private void CapNhatDuLieu()
     {
         try {
              ArrayList<Oto> arrM = new ArrayList<>();
              arrM = model.timKiemTheoMaXe(this.maOto);            
              view.getLblMaXe().setText(arrM.get(0).getMaXeString());
              view.getLblMaXe().setBackground(Color.yellow);
              view.getTxtTenXe().setText(arrM.get(0).getTenXeString());
              view.getTxtMauNoiThat().setText(arrM.get(0).getMauSacNoiThatString());
              view.getTxtXuatXu().setText(arrM.get(0).getXuatXuString());
              view.getTxtDongCo().setText(arrM.get(0).getDongCoString());
              view.getTxtMoTa().setText(arrM.get(0).getMoTaString());
              view.getTxtGia().setText(String.valueOf(arrM.get(0).getGiaFloat()));
              view.getTxtSoGhe().setText(String.valueOf(arrM.get(0).getSoGhe()));
              view.getTxtTrangThai().setText(arrM.get(0).getTrangThai());
              view.getTxtChieuDai().setText(String.valueOf(arrM.get(0).getChieuDai()));
              view.getTxtChieuCao().setText(String.valueOf(arrM.get(0).getChieuCao()));
              view.getTxtSoLuong().setText(String.valueOf(arrM.get(0).getSoLuong()));
              String filePath = arrM.get(0).getHinhAnh();
              BufferedImage buff = new BufferedImage(150, 100, BufferedImage.TYPE_INT_ARGB);
              buff = ImageIO.read(new File(filePath));
              ImageIcon icon = new ImageIcon(buff);
              Image img = icon.getImage();
              Image imgg = img.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
              ImageIcon imgcon = new ImageIcon(imgg);
              view.getjLabel19().setIcon(imgcon);
              view.getjLabel19().setText(filePath);
         } catch (Exception e) {
         }
        
     }
     private BufferedImage getImage(String filename) {
        // This time, you can use an InputStream to load
        try {
            // Grab the InputStream for the image.                    
            InputStream in = getClass().getResourceAsStream(filename);

            // Then read it.
            return ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
            //System.exit(1);
        }

        return null;
    }
    private boolean check_Value() {
        String[] arrayThongTin = new String[]{view.getTxtTenXe().getText(), view.getTxtMauNoiThat().getText(), view.getTxtXuatXu().getText(), view.getTxtMoTa().getText(), view.getTxtGia().getText(), view.getTxtSoGhe().getText(), view.getTxtTrangThai().getText(),
        view.getTxtChieuDai().getText(), view.getTxtChieuCao().getText(), view.getTxtSoLuong().getText()};
        for (String string : arrayThongTin) {
            if (string.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
