/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author hp
 */
public class ChiNhanh {
    private String tenChiNhanhString;
    private String diaChiString;
    private String maNVQL;

    public ChiNhanh() {
    }

    public ChiNhanh(String tenChiNhanhString, String diaChiString, String tenNVQL) {
        this.tenChiNhanhString = tenChiNhanhString;
        this.diaChiString = diaChiString;
        this.maNVQL = tenNVQL;
    }

    public String getTenChiNhanhString() {
        return tenChiNhanhString;
    }

    public void setTenChiNhanhString(String tenChiNhanhString) {
        this.tenChiNhanhString = tenChiNhanhString;
    }

    public String getDiaChiString() {
        return diaChiString;
    }

    public void setDiaChiString(String diaChiString) {
        this.diaChiString = diaChiString;
    }

    public String getMaNVQL() {
        return maNVQL;
    }

    public void setMaNVQL(String maNVQL) {
        this.maNVQL = maNVQL;
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%s", tenChiNhanhString,diaChiString,maNVQL);
    }
    
}
