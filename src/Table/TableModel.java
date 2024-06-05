package Table;

import model.Bill;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.Customer;
import model.User;
public class TableModel {

    public DefaultTableModel setTableCustomer(List<Customer> listItem, String[] listColumn) {
        return setTableModel(listItem, listColumn, new String[]{
            "getMeter_no", "getUser_id", "getName", "getAddress", "getEmail", "getPhone"
        });
    }
    public DefaultTableModel setTableUser(List<User> listItem, String[] listColumn) {
        return setTableModel(listItem, listColumn, new String[]{
            "getUser_id", "getUsername", "getName", "getPassword"
        });
    }

    public DefaultTableModel setTableBill(List<Bill> listItem, String[] listColumn) {
        return setTableModel(listItem, listColumn, new String[]{
            "getId", "getMeter_no", "getMonth","getYear", "getUnits", "getTotal_bill", "getStatus","getDate"
        });
    }

    private DefaultTableModel setTableModel(List<?> listItem, String[] listColumn, String[] getters) {
        DefaultTableModel model = new DefaultTableModel(listColumn, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };

        for (Object item : listItem) {
            Object[] rowData = new Object[getters.length];
            for (int i = 0; i < getters.length; i++) {
                try {
                    rowData[i] = item.getClass().getMethod(getters[i]).invoke(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            model.addRow(rowData);
        }

        return model;
    }

}
