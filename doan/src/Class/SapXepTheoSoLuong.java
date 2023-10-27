/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Class.Oto;
import java.util.Comparator;

/**
 *
 * @author PC
 */
public class SapXepTheoSoLuong implements Comparator<Oto>{
          @Override
    public int compare(Oto oto1, Oto oto2){
        if(oto1.getSoLuong()>oto2.getSoLuong()){
            return 1;
        }
        return -1;
    }
}
