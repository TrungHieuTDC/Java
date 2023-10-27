/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.Oto;
import Model.QuanLyOtoModel;
import View.frmOto;
import View.frmThemXe;
import java.awt.Image;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class QuanLyThemOto_Controller {
    private QuanLyOtoModel model;
    private frmThemXe view;
    DefaultTableModel tbmodel;
    public QuanLyThemOto_Controller() {
    }   

    public QuanLyThemOto_Controller(QuanLyOtoModel model, frmThemXe view) throws Exception{
        this.model = model;
        this.view = view;
        view.setVisible(true);
        frmOto viewOto = new frmOto();
        view.getBtnThem().addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (check_Value() == false) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                    } else {
                        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm dữ liệu?", "Xác nhận thêm dữ liệu", JOptionPane.YES_NO_OPTION);
                        if (confirmResult == JOptionPane.YES_OPTION) {
                            String maOto = view.getTxtMaXe().getText();
                            String tenOto = view.getTxtTenXe().getText();
                            String mauOto = view.getTxtMauNoiThat().getText();
                            String xuatXu = view.getTxtXuatXu().getText();
                            String dongCo = view.getTxtDongCo().getText();
                            String moTa = view.getTxtMoTo().getText();
                            float gia = Float.parseFloat(view.getTxtGia().getText());
                            int soGhe = Integer.parseInt(view.getTxtSoGhe().getText());
                            String trangThai = view.getTxtTrangThai().getText();
                            int chieuDai = Integer.parseInt(view.getTxtChieuDai().getText());
                            int chieuCao = Integer.parseInt(view.getTxtChieuCao().getText());
                            int soLuong = Integer.parseInt(view.getTxtSoLuong().getText());
                            String hinhAnh = view.getjLabel15().getText();
                            Oto oto = new Oto(maOto, tenOto, mauOto, xuatXu, dongCo, moTa, gia, soGhe, trangThai, chieuDai, chieuCao, soLuong, hinhAnh);
                            System.out.println(oto.toString());
                            boolean kq = model.themOto(oto);
                            if (kq) {
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                                 view.dispose();                          
                                 QuanLyOto_Controller ql = new QuanLyOto_Controller(model, viewOto);
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
        view.getjButton1().addActionListener(new ActionListener() {
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
                   view.getjLabel15().setIcon(imgcon);

                   // Gán giá trị mới vào jLabel15
                   view.getjLabel15().setText(filePath);

               } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, "Ban chua chon anh");
               }
           }
       });


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
        String[] arrayThongTin = new String[]{view.getTxtMaXe().getText(), view.getTxtTenXe().getText(), view.getTxtMauNoiThat().getText(), view.getTxtXuatXu().getText(), view.getTxtMoTo().getText(), view.getTxtGia().getText(), view.getTxtSoGhe().getText(), view.getTxtTrangThai().getText(),
        view.getTxtChieuDai().getText(), view.getTxtChieuCao().getText(), view.getTxtSoLuong().getText()};
        for (String string : arrayThongTin) {
            if (string.isEmpty()) {
                return false;
            }
        }
        return true;
    }
   
    
}
  

