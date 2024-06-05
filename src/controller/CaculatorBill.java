
package controller;
import service.CustomerServiceImpl;
import model.Customer;
import java.util.List;
import javax.swing.JOptionPane;
import model.Bill;
import service.BillServiceImpl;
import service.TaxServiceImpl;
import model.Tax;
public class CaculatorBill extends javax.swing.JFrame {

    private CustomerServiceImpl customerService;
    private BillServiceImpl billService;
    public TaxServiceImpl taxService;
    private UserMenu userMenu;
    public CaculatorBill() {
        initComponents();
    }
    public CaculatorBill(UserMenu userMenu) {
        initComponents();
        this.userMenu = userMenu;
        customerService = new CustomerServiceImpl(); 
        billService = new BillServiceImpl();
        taxService = new TaxServiceImpl();
        addMetterNumber();
    }
    public void addMetterNumber() {
        List<Integer> meterNumbers = customerService.getMeterNumbers(userMenu.getLoggedInUsername());
        MetterNoInput.removeAllItems();
        
        for (int meterNumber : meterNumbers) {
            MetterNoInput.addItem(String.valueOf(meterNumber));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        PhaseBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        MonthInput = new javax.swing.JLabel();
        UnitsCosumedInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NameSet = new javax.swing.JLabel();
        AddressSet = new javax.swing.JLabel();
        MetterNoInput = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        YearBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tên");

        PhaseBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PhaseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tính tiền hóa đơn");

        MonthInput.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MonthInput.setText("Tháng");

        UnitsCosumedInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Địa chỉ");

        SubmitButton.setBackground(new java.awt.Color(51, 51, 51));
        SubmitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SubmitButton.setForeground(new java.awt.Color(255, 255, 255));
        SubmitButton.setText("Xác nhận");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Điện tiêu thụ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã đồng hồ");

        NameSet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NameSet.setText("Null");

        AddressSet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddressSet.setText("Null");

        MetterNoInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MetterNoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MetterNoInputActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Năm");

        YearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MonthInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(YearBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UnitsCosumedInput)
                            .addComponent(PhaseBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(NameSet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MetterNoInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AddressSet, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MetterNoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NameSet))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(AddressSet))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(UnitsCosumedInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhaseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MonthInput))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(YearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(SubmitButton)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MetterNoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MetterNoInputActionPerformed

        int selectedMetterNumber = Integer.parseInt(MetterNoInput.getSelectedItem().toString());
        Customer selectedUser = customerService.findCustomerByMeterNumber(selectedMetterNumber);
        if (selectedUser != null) {
            NameSet.setText(selectedUser.getName());
            AddressSet.setText(selectedUser.getAddress());
        } else {
            NameSet.setText("");
            AddressSet.setText("");
        }
    }//GEN-LAST:event_MetterNoInputActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        int meterNo = Integer.parseInt(MetterNoInput.getSelectedItem().toString());
        int month = Integer.parseInt((String) PhaseBox.getSelectedItem());
        int year = Integer.parseInt((String) YearBox.getSelectedItem());
        int units = Integer.parseInt(UnitsCosumedInput.getText());
        String status = "chưa thanh toán";
        Tax tax = taxService.getTaxInfoByMonthAndYear(month, year);
        if (tax != null) {
            float costPerUnit = tax.getUnit_price();
            float serviceCharge = tax.getService_charge();
            float serviceTax = tax.getService_tax();
            float fixedTax = tax.getFixed_tax();
            float price = costPerUnit * units + serviceCharge * serviceTax;
            float totalBill = price  + price * fixedTax;
            String username = userMenu.getLoggedInUsername();
            List<Bill> existingBills = billService.getBillByFilters(username, meterNo, month, year);
            if (existingBills.isEmpty()) {
                Bill bill = new Bill();
                bill.setMeter_no(meterNo);
                bill.setMonth(month);
                bill.setYear(year);
                bill.setUnits(units);
                bill.setTotal_bill(totalBill);
                bill.setStatus(status);

                int result = billService.create(bill);

                if (result != -1) {
                    JOptionPane.showMessageDialog(this,"Hóa đơn đã được tạo thành công!");
                } else {
                    JOptionPane.showMessageDialog(this,"Không thể tạo hóa đơn. Vui lòng thử lại sau!");
                }
            } else {
                JOptionPane.showMessageDialog(this,"Đã tồn tại hóa đơn cho tháng này. Vui lòng chọn tháng khác!");
            }
        } else {
            JOptionPane.showMessageDialog(this,"Không có thông tin thuế cho tháng và năm này. Vui lòng kiểm tra lại!");
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaculatorBill().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressSet;
    private javax.swing.JComboBox<String> MetterNoInput;
    private javax.swing.JLabel MonthInput;
    private javax.swing.JLabel NameSet;
    private javax.swing.JComboBox<String> PhaseBox;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTextField UnitsCosumedInput;
    private javax.swing.JComboBox<String> YearBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
