
package controller;
import model.Customer;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Table.TableModel; 
import javax.swing.JOptionPane;
import service.CustomerServiceImpl;
import service.UserServiceImpl;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerList extends javax.swing.JFrame {

    private final TableModel tableModel; 
    private final CustomerServiceImpl customerService;
    private UserServiceImpl userService;
    private UserMenu userMenu; 
    public CustomerList() {
        initComponents();
        customerService = new CustomerServiceImpl();
        tableModel = new TableModel();
        loadDataToTableAdmin();
        NewCustomer.setVisible(false);
        setLocationRelativeTo(null);
    }
    public CustomerList(UserMenu userMenu) {
        initComponents();
        this.userMenu = userMenu;
        tableModel = new TableModel();
        customerService = new CustomerServiceImpl();
        userService = new UserServiceImpl();
        loadDataToTable();
        addPopup();
    }

    private void addPopup() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editMenuItem = new JMenuItem("Sửa");
        JMenuItem deleteMenuItem = new JMenuItem("Xóa");

        editMenuItem.addActionListener(e -> {
            int selectedRow = TableCustomerDetail.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "chưa chọn khách hàng");
                return;
            }
            int meterNo = Integer.parseInt(TableCustomerDetail.getValueAt(selectedRow, 0).toString());
            int userId = Integer.parseInt(TableCustomerDetail.getValueAt(selectedRow, 1).toString());
            String customerName = TableCustomerDetail.getValueAt(selectedRow, 2).toString();
            String address = TableCustomerDetail.getValueAt(selectedRow, 3).toString();
            String email = TableCustomerDetail.getValueAt(selectedRow, 4).toString();
            String phoneNumber = TableCustomerDetail.getValueAt(selectedRow, 5).toString();

            New_Update_Customer editCustomerDialog = new New_Update_Customer();
            
            editCustomerDialog.setCustomerDetails(meterNo, userId, customerName, address, email, phoneNumber);
            editCustomerDialog.setVisible(true);
            loadDataToTable();
        });

        deleteMenuItem.addActionListener(e -> {
            int selectedRow = TableCustomerDetail.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng để thao tác");
                return;
            }
            int meterNo = Integer.parseInt(TableCustomerDetail.getValueAt(selectedRow, 0).toString());
            customerService.delete(meterNo);
            loadDataToTable();
        });

        popupMenu.add(editMenuItem);
        popupMenu.add(deleteMenuItem);

        TableCustomerDetail.setComponentPopupMenu(popupMenu);
        TableCustomerDetail.addMouseListener(new MouseAdapter() {
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
        List<Customer> customerList = customerService.getListByUsername(userMenu.getLoggedInUsername());
        String[] columnNames = {"Mã đồng hồ", "Mã người dùng", "Tên khách hàng", "Đia chỉ", "Email", "Số điện thoại"};
        DefaultTableModel model = tableModel.setTableCustomer(customerList, columnNames); 
        TableCustomerDetail.setModel(model);
    }
    private void loadDataToTableAdmin() {
        List<Customer> customerList = customerService.getList();
        String[] columnNames = {"Mã đồng hồ", "Mã người dùng", "Tên khách hàng", "Đia chỉ", "Email", "Số điện thoại"};
        DefaultTableModel model = tableModel.setTableCustomer(customerList, columnNames); 
        TableCustomerDetail.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCustomerDetail = new javax.swing.JTable();
        NewCustomer = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách khách hàng");

        TableCustomerDetail.setAutoCreateRowSorter(true);
        TableCustomerDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đồng hồ", "Mã người dùng", "Tên khách hàng", "Địa chỉ", "Email", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCustomerDetail.setRowHeight(30);
        jScrollPane2.setViewportView(TableCustomerDetail);

        NewCustomer.setText("Thêm khách hàng");
        NewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(NewCustomer)
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NewCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewCustomerActionPerformed
        New_Update_Customer newCustomer = new New_Update_Customer(this.userMenu);
        newCustomer.setVisible(true);
    }//GEN-LAST:event_NewCustomerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerList().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NewCustomer;
    private javax.swing.JTable TableCustomerDetail;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
