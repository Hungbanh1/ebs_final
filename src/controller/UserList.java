
package controller;
import model.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Table.TableModel; 
import javax.swing.JOptionPane;
import service.UserServiceImpl;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserList extends javax.swing.JFrame {

    private final TableModel tableModel; 
    private UserServiceImpl userService;
    public UserList() {
        tableModel = new TableModel();
        userService = new UserServiceImpl();
        initComponents();
        loadDataToTable();
        addPopup();
    }
    private void addPopup() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editMenuItem = new JMenuItem("Sửa");
        JMenuItem deleteMenuItem = new JMenuItem("Xóa");

        editMenuItem.addActionListener(e -> {
            int selectedRow = TableUserDetail.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Không hàng nào được chọn cả.");
                return;
            }
            NewUser editUserDialog = new NewUser();
            editUserDialog.setVisible(true);
            String username = TableUserDetail.getValueAt(selectedRow, 1).toString();
            String name = TableUserDetail.getValueAt(selectedRow, 2).toString();
            NewUser updateUser = new NewUser();
            updateUser.setUserEdit(username, name);
            updateUser.setVisible(true);
            loadDataToTable();
        });

        deleteMenuItem.addActionListener(e -> {
            int selectedRow = TableUserDetail.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Không hàng nào được chọn cả.");
                return;
            }
            int userId = Integer.parseInt(TableUserDetail.getValueAt(selectedRow, 0).toString());
            
            userService.delete(userId);
            loadDataToTable();
        });

        popupMenu.add(editMenuItem);
        popupMenu.add(deleteMenuItem);

        TableUserDetail.setComponentPopupMenu(popupMenu);

        // Add mouse listener to handle popup trigger
        TableUserDetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            private void showPopup(MouseEvent e) {
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
    private void loadDataToTable() {
        List<User> userList = userService.getList();
        String[] columnNames = {"Mã người dùng", "Tên đăng nhập", "Tên", "Mật khẩu"};
        DefaultTableModel model = tableModel.setTableUser(userList, columnNames); 
        TableUserDetail.setModel(model);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableUserDetail = new javax.swing.JTable();
        TittleUser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableUserDetail.setAutoCreateRowSorter(true);
        TableUserDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người dùng", "Tên đăng nhập", "Tên", "Mật khẩu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableUserDetail.setRowHeight(30);
        jScrollPane2.setViewportView(TableUserDetail);

        TittleUser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TittleUser.setText("Danh sách người dùng");

        jButton1.setText("Thêm người dùng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TittleUser)
                .addGap(196, 196, 196))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TittleUser)
                    .addComponent(jButton1))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NewUser newUser = new NewUser();
        newUser.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUserDetail;
    private javax.swing.JLabel TittleUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
