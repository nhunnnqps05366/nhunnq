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
public class diem {

     public String masv;
    public double java, sql, av, tb;

    public diem(String masv, double jav, double sql, double av, double tb) {
        this.masv = masv;
        this.java = jav;
        this.sql = sql;
        this.av = av;
        this.tb=tb;
    }

    public diem(double java) {
        this.java = java;
    }

    

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getSql() {
        return sql;
    }

    public void setSql(double sql) {
        this.sql = sql;
    }

    public double getAv() {
        return av;
    }

    public void setAv(double av) {
        this.av = av;
    }

    public double getTb() {
        return tb;
    }

    public void setTb(double tb) {
        this.tb = tb;
    }

 



}
