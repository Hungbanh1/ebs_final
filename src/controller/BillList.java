
package controller;
import model.Bill;
import model.Customer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import Table.TableModel;
import service.BillServiceImpl;
import service.CustomerServiceImpl;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Tax;
import service.TaxServiceImpl;
public class BillList extends javax.swing.JFrame {

    private TableModel tableModel; 
    public BillServiceImpl billService ;
    public CustomerServiceImpl customerService;
    public TaxServiceImpl taxService;
    private JPopupMenu popupMenu;
    private UserMenu userMenu;
    public BillList() {
        initComponents();
        billService = new BillServiceImpl();
        customerService = new CustomerServiceImpl();
        tableModel = new TableModel();
        loadDataToTableBillAdmin();
        setLocationRelativeTo(null);
    }
    public BillList(UserMenu userMenu) {
        initComponents();
        this.userMenu = userMenu;
        tableModel = new TableModel();
        billService = new BillServiceImpl();
        customerService = new CustomerServiceImpl();
        taxService = new TaxServiceImpl();
        loadDataToTableBill();
        popupMenu = new JPopupMenu();
        JMenuItem printMenuItem = new JMenuItem("In");
        JMenuItem paymentMenuItem = new JMenuItem("Thanh toán");
        JMenuItem deleteMenuItem = new JMenuItem("Xóa");
        printMenuItem.addActionListener((e) -> {
            Bill selectedBill = getSelectedBillFromTable();
            if (selectedBill != null) {
                generateBillPDF(selectedBill);
            }
        });
        paymentMenuItem.addActionListener((e) -> {
                processPayment();
        });
        deleteMenuItem.addActionListener((e) -> {
            int selectedRow = TableDepositDetail.getSelectedRow();
            int id = Integer.parseInt(TableDepositDetail.getValueAt(selectedRow, 0).toString());
            if (selectedRow != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean success = billService.delete(id);
                    if (success) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công hóa đơn.");
                        loadDataToTableBill();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                    }
                }
            }
        });
        popupMenu.add(printMenuItem);
        popupMenu.add(paymentMenuItem);
        popupMenu.add(deleteMenuItem);
        TableDepositDetail.setComponentPopupMenu(popupMenu);
    }
    private void createBillTable(List<Bill> bills) {
        String[] columnNames = {"Mã hóa đơn","Mã đồng hồ", "Tháng", "Năm", "Điện tiêu thụ", "Thành tiền", "Trạng thái", "Ngày trả"};
        DefaultTableModel model = tableModel.setTableBill(bills, columnNames); 
        TableDepositDetail.setModel(model);
    }
    private void loadDataToTableBill() {
        List<Bill> billList = billService.getBillByUsername(userMenu.getLoggedInUsername());
        createBillTable(billList);
    }
    private void loadDataToTableBillAdmin() {
        List<Bill> billList = billService.getList();
        createBillTable(billList);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        SearchMetterNumberInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        SearchTable = new javax.swing.JScrollPane();
        TableDepositDetail = new javax.swing.JTable();
        SortMonthBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        SortYearBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Bộ lọc mã khách hàng");

        SearchMetterNumberInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Bộ lọc tháng");

        SearchButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchButton.setText("Tìm kiếm");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchTable.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TableDepositDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã đồng hồ", "Tháng", "Năm", "Điện tiêu thụ", "Thành tiền", "Trạng thái", "Ngày trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDepositDetail.setRowHeight(30);
        SearchTable.setViewportView(TableDepositDetail);

        SortMonthBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SortMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Bộ lọc năm");

        SortYearBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SortYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SearchTable, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(SearchMetterNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(SearchButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SortMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SortYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(SearchMetterNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SortMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(SortYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(SearchTable, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
                                       
        try {
            String meterNoStr = SearchMetterNumberInput.getText().trim();
            String monthStr = ((String) SortMonthBox.getSelectedItem()).trim();
            String yearStr = ((String) SortYearBox.getSelectedItem()).trim();
            String username = userMenu != null ? userMenu.getLoggedInUsername() : null;
            Integer meterNo = meterNoStr.isEmpty() ? null : Integer.parseInt(meterNoStr);
            Integer month = monthStr.isEmpty() ? null : Integer.parseInt(monthStr);
            Integer year = yearStr.isEmpty() ? null : Integer.parseInt(yearStr);
            List<Bill> bills = billService.getBillByFilters(username, meterNo, month, year);
            createBillTable(bills);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Đinh dạng không đúng vui lòng thử lại", "Lỗi nhập", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed
    private Bill getSelectedBillFromTable() {
        int selectedRowIndex = TableDepositDetail.getSelectedRow();
        if (selectedRowIndex != -1) { 
            
            int meterNo = Integer.parseInt(TableDepositDetail.getValueAt(selectedRowIndex, 1).toString());
            int month = Integer.parseInt(TableDepositDetail.getValueAt(selectedRowIndex, 2).toString());
            int year = Integer.parseInt(TableDepositDetail.getValueAt(selectedRowIndex, 3).toString());
            int units = Integer.parseInt(TableDepositDetail.getValueAt(selectedRowIndex, 4).toString());
            float totalBill = Float.parseFloat(TableDepositDetail.getValueAt(selectedRowIndex, 5).toString());
            String status = TableDepositDetail.getValueAt(selectedRowIndex, 6).toString();
            java.util.Date date = (java.util.Date) TableDepositDetail.getValueAt(selectedRowIndex, 7);

            Bill selectedBill = new Bill();
            selectedBill.setMeter_no(meterNo);
            selectedBill.setMonth(month);
            selectedBill.setYear(year);
            selectedBill.setUnits(units);
            selectedBill.setTotal_bill(totalBill);
            selectedBill.setStatus(status);
            selectedBill.setDate(date);

            return selectedBill;
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán!");
            return null;
        }
    }
    public void generateBillPDF(Bill bill) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("bill/Bill_" + bill.getMeter_no() + "-" +  bill.getMonth()+ "-" + bill.getYear() + ".pdf"));
            document.open();
            // Title
            BaseFont boldFont = BaseFont.createFont("ttf/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            BaseFont normalFont = BaseFont.createFont("ttf/SVN-Times New Roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font vietnameseFontBold = new Font(boldFont, 12);
            Font vietnameseFontNormal = new Font(normalFont, 12);
            Paragraph title = new Paragraph("HÓA ĐƠN", new Font(boldFont, 20, Font.BOLD, BaseColor.BLUE));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            PdfPTable billTable = new PdfPTable(2);
            billTable.setWidthPercentage(100);
            billTable.setSpacingBefore(10f);
            billTable.setSpacingAfter(10f);

            PdfPCell cell;

            cell = new PdfPCell(new Phrase("Thông tin hóa đơn", vietnameseFontBold));
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            billTable.addCell(cell);
            billTable.addCell(new Phrase("Mã hóa đơn:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(bill.getId()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Số đồng hồ:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(bill.getMeter_no()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Tháng:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(bill.getMonth()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Năm:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(bill.getYear()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Điện tiêu thụ:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(bill.getUnits()), vietnameseFontNormal));
            Tax tax = taxService.getTaxInfoByMonthAndYear(bill.getMonth(), bill.getYear());
            billTable.addCell(new Phrase("Đơn giá:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(tax.getUnit_price()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Phí dịch vụ:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(tax.getService_charge()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Thuế dịch vụ:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(tax.getService_tax()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Thuế cố định:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(tax.getFixed_tax()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Thành tiền:", vietnameseFontBold));
            billTable.addCell(new Phrase(String.valueOf(bill.getTotal_bill()), vietnameseFontNormal));
            billTable.addCell(new Phrase("Trạng thái:", vietnameseFontBold));
            billTable.addCell(new Phrase(bill.getStatus(), vietnameseFontNormal));

            Date date = bill.getDate();
            String formattedDate = "";
            if (date != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                formattedDate = dateFormat.format(date);
            } else {
                formattedDate = "N/A"; 
            }

            billTable.addCell(new Phrase("Ngày trả:", vietnameseFontBold));
            billTable.addCell(new Phrase(formattedDate, vietnameseFontNormal));

            document.add(billTable);

            // Customer details
            Customer customer = customerService.findCustomerByMeterNumber(bill.getMeter_no());
            if (customer != null) {
                PdfPTable customerTable = new PdfPTable(2);
                customerTable.setWidthPercentage(100);
                customerTable.setSpacingBefore(10f);
                customerTable.setSpacingAfter(10f);

                cell = new PdfPCell(new Phrase("Thông tin khách hàng", vietnameseFontBold));
                cell.setColspan(2);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                customerTable.addCell(cell);

                customerTable.addCell(new Phrase("Tên:", vietnameseFontBold));
                customerTable.addCell(new Phrase(customer.getName(), vietnameseFontNormal));
                customerTable.addCell(new Phrase("Địa chỉ:", vietnameseFontBold));
                customerTable.addCell(new Phrase(customer.getAddress(), vietnameseFontNormal));
                customerTable.addCell(new Phrase("Email:", vietnameseFontBold));
                customerTable.addCell(new Phrase(customer.getEmail(), vietnameseFontNormal));
                customerTable.addCell(new Phrase("Số điện thoại:", vietnameseFontBold));
                customerTable.addCell(new Phrase(customer.getPhone(), vietnameseFontNormal));

                document.add(customerTable);
            }

            Paragraph footer = new Paragraph("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!", new Font(boldFont, 12, Font.ITALIC, BaseColor.GRAY));
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(20);
            document.add(footer);
            document.close();

            JOptionPane.showMessageDialog(this, "File pdf được tạo thành công!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi xử lý file pdf: " + ex.getMessage());
        }}

    private void processPayment() {
        int selectedRow = TableDepositDetail.getSelectedRow();
        if (selectedRow != -1) {
            int metterNo = Integer.parseInt(TableDepositDetail.getValueAt(selectedRow, 1).toString());
            int  month = Integer.parseInt(TableDepositDetail.getValueAt(selectedRow, 2).toString());
            int year = Integer.parseInt(TableDepositDetail.getValueAt(selectedRow, 3).toString());
            int units = Integer.parseInt(TableDepositDetail.getValueAt(selectedRow, 4).toString());
            float totalBill = Float.parseFloat(TableDepositDetail.getValueAt(selectedRow, 5).toString());
            String status = TableDepositDetail.getValueAt(selectedRow, 6).toString();

            if (!status.equals("đã thanh toán")) {
                Bill selectedBill = new Bill();
                selectedBill.setMeter_no(metterNo);
                selectedBill.setMonth(month);
                selectedBill.setYear(year);
                selectedBill.setUnits(units);
                selectedBill.setTotal_bill(totalBill);
                selectedBill.setStatus(status);

                PayBill payBill = new PayBill(selectedBill);
                payBill.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this,"Hóa đơn đã được thanh toán.");
            }
        }
}

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
            java.util.logging.Logger.getLogger(BillList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BillList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchMetterNumberInput;
    private javax.swing.JScrollPane SearchTable;
    private javax.swing.JComboBox<String> SortMonthBox;
    private javax.swing.JComboBox<String> SortYearBox;
    private javax.swing.JTable TableDepositDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
