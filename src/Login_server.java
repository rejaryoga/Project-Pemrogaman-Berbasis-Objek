import Database.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Login_server extends javax.swing.JFrame {

    ResultSet rs;
    KoneksiDatabase con;
    String id_user;
    String hak;

  
    public Login_server() {
        con = new KoneksiDatabase(new Database.Parameter().HOST_DB, new Database.Parameter().USERNAME_DB, new Database.Parameter().PASSWORD_DB);
        initComponents();
        setLocationRelativeTo(null);

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlass1 = new usu.widget.glass.PanelGlass();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new usu.widget.ButtonGlass();
        btn_close = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 102));
        setUndecorated(true);
        setSize(new java.awt.Dimension(650, 400));

        panelGlass1.setBackground(new java.awt.Color(102, 0, 51));
        panelGlass1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setBackground(new java.awt.Color(204, 204, 204));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        panelGlass1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 35, 205, -1));

        txt_password.setBackground(new java.awt.Color(204, 204, 204));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        panelGlass1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 73, 205, -1));

        btn_login.setForeground(new java.awt.Color(0, 51, 204));
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panelGlass1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 100, -1));

        btn_close.setForeground(new java.awt.Color(0, 0, 255));
        btn_close.setText("Close");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        panelGlass1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel1.setText("PASSWORD");
        panelGlass1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 76, 77, -1));

        jLabel3.setText("USERNAME");
        panelGlass1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 38, 77, -1));

        jLabel5.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("MENU LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(panelGlass1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelGlass1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass2ActionPerformed
    }//GEN-LAST:event_buttonGlass2ActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        try {
            rs = con.querySelectAll("user", "username='" + txt_username.getText() + "' and password='" + txt_password.getText() + "'");
            while (rs.next()) {
                id_user = rs.getString("id_user");

                hak = rs.getString("type");
            }
        } catch (SQLException ex) {
        }

        if (id_user != null) {

            this.dispose();
            if (hak.equals("Admin")) {
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                Home h = new Home();
                h.setVisible(true);
                h.admin();
            } else {
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                Home h = new Home();
                h.setVisible(true);
                h.user();
            }


        } else {
            JOptionPane.showMessageDialog(this, "Login Gagal, Coba Lagi!!");
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
       
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login_server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_close;
    private usu.widget.ButtonGlass btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
