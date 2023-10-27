/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Class.GiaoDich;
import java.util.Comparator;

/**
 *
 * @author PC
 */
public class SapXepThoiGianGD implements Comparator<GiaoDich>{
     @Override
    public int compare(GiaoDich gd1, GiaoDich gd2){
        if(gd1.getThoiGian().compareTo(gd2.getThoiGian())>0 ){
            return 1;
        }
        return -1;
    }
}
