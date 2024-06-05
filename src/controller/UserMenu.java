
package controller;

import javax.swing.ImageIcon;


public class UserMenu extends javax.swing.JFrame {

    
    public UserMenu() {
        initComponents();
        setIconInButton();
        setLocationRelativeTo(null);
    }
    public Login loginInstance;
    public void setLoginInstance(Login loginInstance) {
        this.loginInstance = loginInstance;
        String loggedInUsername = loginInstance.getLoggedInUsername();
    }
    public String getLoggedInUsername() {
        return this.loginInstance != null ? this.loginInstance.getLoggedInUsername() : null;
    }
//    public void setImage(){
//        ImageIcon imageElectric = new ImageIcon(getClass().getResource("/images/thongke.png"));
//        Image img = imageElectric.getImage().getScaledInstance(jLabelThongKe.getWidth(),jLabelThongKe.getHeight(),Image.SCALE_SMOOTH);
//        jLabelThongKe.setIcon(new ImageIcon(img));
//    }
    public void setIconInButton(){


            //1
        CaculatorBill.setIcon(new ImageIcon(getClass().getResource("/images/update-cus-ic.png")));
        //2
        CustomerListUserButton.setIcon(new ImageIcon(getClass().getResource("/images/info-user-ic.png")));
        // 4
        BillListButton.setIcon(new ImageIcon(getClass().getResource("/images/bill-detail-ic.png")));
        // 5
        ThongKe.setIcon(new ImageIcon(getClass().getResource("/images/thongke-ic.png")));
        // 6
        LogoutButton.setIcon(new ImageIcon(getClass().getResource("/images/logout-ic.png")));
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CaculatorBill = new javax.swing.JButton();
        BillListButton = new javax.swing.JButton();
        CustomerListUserButton = new javax.swing.JButton();
        ThongKe = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        CaculatorBill.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CaculatorBill.setText("Tạo hóa đơn");
        CaculatorBill.setPreferredSize(new java.awt.Dimension(100, 100));
        CaculatorBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaculatorBillActionPerformed(evt);
            }
        });

        BillListButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BillListButton.setText("Chi tiết hóa đơn");
        BillListButton.setPreferredSize(new java.awt.Dimension(100, 100));
        BillListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillListButtonActionPerformed(evt);
            }
        });

        CustomerListUserButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CustomerListUserButton.setText("Danh sách khách hàng của người dùng");
        CustomerListUserButton.setPreferredSize(new java.awt.Dimension(100, 100));
        CustomerListUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerListUserButtonActionPerformed(evt);
            }
        });

        ThongKe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ThongKe.setText("Thống kê");
        ThongKe.setPreferredSize(new java.awt.Dimension(100, 100));
        ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeActionPerformed(evt);
            }
        });

        LogoutButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LogoutButton.setText("Đăng xuất");
        LogoutButton.setPreferredSize(new java.awt.Dimension(100, 100));
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("DANH MỤC NGƯỜI DÙNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addComponent(BillListButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerListUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CaculatorBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(CaculatorBill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(CustomerListUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(BillListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CaculatorBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaculatorBillActionPerformed
        jPanel3.removeAll();
        CaculatorBill caculatorBill = new CaculatorBill(this);
        jPanel3.add(caculatorBill.getContentPane());
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_CaculatorBillActionPerformed

    private void BillListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillListButtonActionPerformed
        jPanel3.removeAll();
        BillList billList = new BillList(this);
        jPanel3.add(billList.getContentPane());
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_BillListButtonActionPerformed

    private void CustomerListUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerListUserButtonActionPerformed
        jPanel3.removeAll();
        CustomerList customerList = new CustomerList(this);
        jPanel3.add(customerList.getContentPane());
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_CustomerListUserButtonActionPerformed

    private void ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeActionPerformed
        jPanel3.removeAll();
        ThongKeUser thongKeUser = new ThongKeUser(this);
        jPanel3.add(thongKeUser.getContentPane());
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_ThongKeActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_LogoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserMenu customerMenu = new UserMenu();
                customerMenu.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BillListButton;
    private javax.swing.JButton CaculatorBill;
    private javax.swing.JButton CustomerListUserButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
