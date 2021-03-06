/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS05366;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author NNQ Hanie
 */
public class qldiem extends javax.swing.JFrame {

    public qldiem() throws ClassNotFoundException, SQLException, SQLException {
        initComponents();
        hienthi();
        setLocationRelativeTo(null);
    }
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDT;user=sa;password=123";

    public ArrayList<diem> sinhvienlist() throws ClassNotFoundException, SQLException {
        ArrayList<diem> ds = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url);
            String query = "select * from SinhVien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            diem diem = null;
            while (rs.next()) {
                diem = new diem(rs.getString("MaSV"), rs.getDouble("diemjava"), rs.getDouble("diemsql"), rs.getDouble("diemav"), rs.getDouble("diemtb"));
                ds.add(diem);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return ds; 
    }

    public void hienthi() throws ClassNotFoundException, SQLException {
        ArrayList<diem> list = sinhvienlist();
        DefaultTableModel md = (DefaultTableModel) tbds.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMasv();
            row[1] = list.get(i).getJava();
            row[2] = list.get(i).getSql();
            row[3] = list.get(i).getAv();
            row[4] = list.get(i).getTb();
            md.addRow(row);
        }
    }

    public void status(String query, String message) throws SQLException {
        try {
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                DefaultTableModel md = (DefaultTableModel) tbds.getModel();
                md.setRowCount(0);
                hienthi();
                JOptionPane.showMessageDialog(null, "Already " + message);
            } else {
                JOptionPane.showMessageDialog(null, "Error " + message);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btupdate = new javax.swing.JButton();
        btfind = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtsql = new javax.swing.JTextField();
        txtjava = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        English = new javax.swing.JLabel();
        txten = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbds = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txttb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtma = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtfind = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Itemhome = new javax.swing.JMenuItem();
        Itemuser = new javax.swing.JMenuItem();
        Itempass = new javax.swing.JMenuItem();
        Itemexit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Itemsv = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Point management");
        setBackground(new java.awt.Color(36, 47, 65));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        btupdate.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\edit.png")); // NOI18N
        btupdate.setText("Update");
        btupdate.setFocusable(false);
        btupdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btupdate.setPreferredSize(new java.awt.Dimension(150, 60));
        btupdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });
        jToolBar1.add(btupdate);

        btfind.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\find.png")); // NOI18N
        btfind.setText("Find");
        btfind.setFocusable(false);
        btfind.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btfind.setPreferredSize(new java.awt.Dimension(150, 60));
        btfind.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfindActionPerformed(evt);
            }
        });
        jToolBar1.add(btfind);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Student code :");

        txtsql.setBackground(new java.awt.Color(36, 47, 65));
        txtsql.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtsql.setForeground(new java.awt.Color(255, 255, 255));
        txtsql.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsql.setBorder(null);

        txtjava.setBackground(new java.awt.Color(36, 47, 65));
        txtjava.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtjava.setForeground(new java.awt.Color(255, 255, 255));
        txtjava.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtjava.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("JAVA               :");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("SQL                  :");

        English.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        English.setForeground(new java.awt.Color(51, 102, 255));
        English.setText("English           :");

        txten.setBackground(new java.awt.Color(36, 47, 65));
        txten.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txten.setForeground(new java.awt.Color(255, 255, 255));
        txten.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txten.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Eras Light ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Point management");

        tbds.setBackground(new java.awt.Color(240, 240, 240));
        tbds.setForeground(new java.awt.Color(36, 47, 65));
        tbds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student code", "JAVA", "SQL", "English", "AVG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbds);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setText("AVG               :");

        txttb.setBackground(new java.awt.Color(36, 47, 65));
        txttb.setForeground(new java.awt.Color(255, 255, 255));
        txttb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setBackground(new java.awt.Color(36, 47, 65));
        jButton3.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jButton3.setText("UPDATE POINT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtma.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtma.setForeground(new java.awt.Color(255, 255, 255));
        txtma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtsql))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(txtjava, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(English, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txten)
                            .addComponent(txttb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator5)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtjava, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsql, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(English, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(txttb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtfind.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtfind.setForeground(new java.awt.Color(51, 102, 255));
        txtfind.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfind.setText("                  Enter the student code to find");
        txtfind.setBorder(null);
        txtfind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtfindMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtfind, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtfind)
                .addGap(0, 0, 0))
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(56, 24));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(161, 35));

        jMenu1.setForeground(new java.awt.Color(0, 0, 51));
        jMenu1.setText("   System");
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 19));
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        Itemhome.setForeground(new java.awt.Color(0, 0, 51));
        Itemhome.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\home.png")); // NOI18N
        Itemhome.setText("Home page");
        Itemhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemhomeActionPerformed(evt);
            }
        });
        jMenu1.add(Itemhome);

        Itemuser.setForeground(new java.awt.Color(0, 0, 51));
        Itemuser.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\user.png")); // NOI18N
        Itemuser.setText("User Management");
        Itemuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemuserActionPerformed(evt);
            }
        });
        jMenu1.add(Itemuser);

        Itempass.setForeground(new java.awt.Color(0, 0, 51));
        Itempass.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\key.png")); // NOI18N
        Itempass.setText("Change Password");
        Itempass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItempassActionPerformed(evt);
            }
        });
        jMenu1.add(Itempass);

        Itemexit.setForeground(new java.awt.Color(0, 0, 51));
        Itemexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\exit.png")); // NOI18N
        Itemexit.setText("Exit");
        Itemexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemexitActionPerformed(evt);
            }
        });
        jMenu1.add(Itemexit);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 51));
        jMenu2.setText(" Manager");
        jMenu2.setPreferredSize(new java.awt.Dimension(60, 19));

        Itemsv.setForeground(new java.awt.Color(0, 0, 51));
        Itemsv.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\sv.png")); // NOI18N
        Itemsv.setText("Student  Management");
        Itemsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemsvActionPerformed(evt);
            }
        });
        jMenu2.add(Itemsv);

        jMenuBar1.add(jMenu2);

        jMenu6.setForeground(new java.awt.Color(0, 0, 51));
        jMenu6.setText("    Help");
        jMenu6.setPreferredSize(new java.awt.Dimension(60, 19));

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\NNQ Hanie\\Desktop\\ASM2_PS05366\\about.png")); // NOI18N
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ItemhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemhomeActionPerformed
        try {
            main a = new main();
            a.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }      // TODO add your handling code here:
    }//GEN-LAST:event_ItemhomeActionPerformed

    private void ItempassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItempassActionPerformed
        // TODO add your handling code here:\
 try {
            doipass a = new doipass();
            a.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }//GEN-LAST:event_ItempassActionPerformed

    private void ItemexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemexitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ItemexitActionPerformed

    private void btupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdateActionPerformed
    
    }//GEN-LAST:event_btupdateActionPerformed

    private void txtfindMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfindMouseReleased
        // TODO add your handling code here:
        txtfind.setText("");
    }//GEN-LAST:event_txtfindMouseReleased

    private void tbdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdsMouseClicked
       int i = tbds.getSelectedRow();
        TableModel md = tbds.getModel();
        txtma.setText(md.getValueAt(i, 0).toString());
        txtjava.setText(md.getValueAt(i, 1).toString());
        txtsql.setText(md.getValueAt(i, 2).toString());
        txten.setText(md.getValueAt(i, 3).toString());
        txttb.setText(md.getValueAt(i, 4).toString());
      
    }//GEN-LAST:event_tbdsMouseClicked

    private void btfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfindActionPerformed
try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select * from SinhVien where MaSV = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtfind.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String a = rs.getString("MaSV");
                String b = rs.getString("DiemJava");
                String c = rs.getString("Diemsql");
                String d = rs.getString("DiemAV");
                String e = rs.getString("DiemTB");
                JOptionPane.showMessageDialog(this, "Had found", "Notify", 1);
                for (int i = 0; i < sinhvienlist().size(); i++) {
                    txtma.setText(a);
                    txtjava.setText(b);
                    txtsql.setText(c);
                    txten.setText(d);
                    txttb.setText(e);
                }
             
            } else {
                JOptionPane.showMessageDialog(this, "Not found", "Notify", 1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btfindActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if (quyen.quyen1.equalsIgnoreCase("Admin")) {
        } else if (quyen.quyen1.equalsIgnoreCase("Lecturers")) {
            Itemsv.setEnabled(false);
            Itemuser.setEnabled(false);
        } else if (quyen.quyen1.equalsIgnoreCase("Staff")) {
            Itemuser.setEnabled(false);
            Itemsv.setEnabled(false);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        tbds.setEnabled(false);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void ItemuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemuserActionPerformed
      try {
            qluser a = new qluser();
            a.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }//GEN-LAST:event_ItemuserActionPerformed

    private void ItemsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemsvActionPerformed
        // TODO add your handling code here:
        try {
            qlsinhvien a = new qlsinhvien();
            a.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }//GEN-LAST:event_ItemsvActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(add()==1){
            them();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(this, "Assignment SOF203"
            + "\nPerform :              Như NNQ"
            + "\nSupport :               Vũ LNH -- Anh NX "
            + "\nInstructor :         HuongTT"
            + "\nLicense :               NhunnqPS05366", "Notify", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
   
    public void them() {
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select * from SinhVien where MaSV = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtma.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String qq = "update SinhVien set DiemJava=" + txtjava.getText() + ",Diemsql=" + txtsql.getText() + ",DiemAV=" + txten.getText() + " where MaSV='" + txtma.getText() + "'";
                try {
                    Connection con = DriverManager.getConnection(url);
                    Statement st = con.createStatement();
                    if ((st.executeUpdate(qq)) == 1) {
                        DefaultTableModel xx = (DefaultTableModel) tbds.getModel();
                        xx.setRowCount(0);
                        hienthi();
                        JOptionPane.showMessageDialog(null, "Add new points ");
                        xoa();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Student code does not exist", "Notify", 1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public int add(){
        String qq= txtjava.getText();
        if(qq.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter point java");
            txtjava.requestFocus();
            return 0;
        } if(Double.parseDouble(txtjava.getText()) >11 || Double.parseDouble(txtjava.getText()) <-1){
            JOptionPane.showMessageDialog(null, "0-10");
            txtjava.requestFocus();
            return 0;
        }
        if(qq.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter point sql");
            txtsql.requestFocus();
            return 0;
        } if(Double.parseDouble(txtsql.getText()) >11 || Double.parseDouble(txtsql.getText()) <-1){
            JOptionPane.showMessageDialog(null, "0-10");
            txtjava.requestFocus();
            return 0;
        }
        if(qq.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter point english");
            txten.requestFocus();
            return 0;
        } if(Double.parseDouble(txten.getText()) >11 || Double.parseDouble(txten.getText()) <-1){
            JOptionPane.showMessageDialog(null, "0-10");
            txten.requestFocus();
            return 0;
        }
        return 1;
    }
    
    public void xoa(){
        txtma.setText("");
        txtjava.setText("");
        txtsql.setText("");
        txten.setText("");
        txttb.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                      try {
                    new qldiem().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(qldiem.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(qldiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel English;
    private javax.swing.JMenuItem Itemexit;
    private javax.swing.JMenuItem Itemhome;
    private javax.swing.JMenuItem Itempass;
    private javax.swing.JMenuItem Itemsv;
    private javax.swing.JMenuItem Itemuser;
    private javax.swing.JButton btfind;
    private javax.swing.JButton btupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbds;
    private javax.swing.JTextField txten;
    private javax.swing.JTextField txtfind;
    private javax.swing.JTextField txtjava;
    private javax.swing.JLabel txtma;
    private javax.swing.JTextField txtsql;
    private javax.swing.JLabel txttb;
    // End of variables declaration//GEN-END:variables

}
