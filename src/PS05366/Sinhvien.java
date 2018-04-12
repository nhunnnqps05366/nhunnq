/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS05366;

/**
 *
 * @author NNQ Hanie
 */
public class Sinhvien {

    public String masv, ten, ngaysinh, lop;
    public float java, sql, av, tb;

    public Sinhvien(String masv, String ten, String ngaysinh, String lop,float java, float sql, float av, float tb) {
        this.masv = masv;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.lop = lop;
        this.java=java;
        this.sql=sql;
        this.av=av;
        this.tb=tb;
    }

    public String getmasv() {
        return masv;
    }

    public String gettensv() {
        return ten;
    }

    public String getngaysinh() {
        return ngaysinh;
    }

    public String getlop() {
        return lop;
    }
}
