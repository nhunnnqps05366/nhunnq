/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS05366;

/**
 *
 * @author Genn
 */
public class quyen {

    public static String mauser,ten1, pass1, quyen1;

    public quyen(String mauser, String ten, String password, String quyenn) {
        this.mauser=mauser;
        this.ten1 = ten;
        this.pass1 = password;
        this.quyen1 = quyenn;
    }

    public static String getMauser() {
        return mauser;
    }

    public void setMauser(String mauser) {
        this.mauser = mauser;
    }
    
    public String getTenser() {
        return ten1;
    }

    public void setTenser(String tenser) {
        this.ten1 = tenser;
    }

    public String getPasss() {
        return pass1;
    }

    public void setPasss(String passs) {
        this.pass1 = passs;
    }

    public String getQuyenn() {
        return quyen1;
    }

    public void setQuyenn(String quyenn) {
        this.quyen1 = quyenn;
    }


    
}
