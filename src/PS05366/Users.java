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
public class Users {
        int mauser;
    String ten,user,pass,quyen;
    public Users(int mauser, String ten, String user, String pass, String quyen){
        this.mauser= mauser;
        this.ten=ten;
        this.user=user;
        this.pass=pass;
        this.quyen=quyen;
    }

    public int getMauser() {
        return mauser;
    }

    public void setMauser(int mauser) {
        this.mauser = mauser;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
}
