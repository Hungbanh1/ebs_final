
package connected;
import model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> getList() {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM customer";
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer infoCustomerService = new Customer();
                infoCustomerService.setMeter_no(rs.getInt("meter_no"));
                infoCustomerService.setUser_id(rs.getInt("user_id"));
                infoCustomerService.setName(rs.getString("name"));
                infoCustomerService.setAddress(rs.getString("address"));
                infoCustomerService.setEmail(rs.getString("email"));
                infoCustomerService.setPhone(rs.getString("phone"));
                list.add(infoCustomerService);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
    @Override
    public boolean create(Customer infoCustomerService) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "INSERT INTO customer(meter_no, user_id, name, address, email, phone) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, infoCustomerService.getMeter_no());
            ps.setInt(2, infoCustomerService.getUser_id());
            ps.setString(3, infoCustomerService.getName());
            ps.setString(4, infoCustomerService.getAddress());
            ps.setString(5, infoCustomerService.getEmail());
            ps.setString(6, infoCustomerService.getPhone());
            boolean executedSuccessfully = ps.executeUpdate() > 0;
            ps.close();
            cons.close();
            return executedSuccessfully;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        }
    @Override
    public boolean update(Customer infoCustomerService) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "UPDATE customer SET name = ?, address = ?, email = ?, phone = ? WHERE meter_no = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, infoCustomerService.getName());
            ps.setString(2, infoCustomerService.getAddress());
            ps.setString(3, infoCustomerService.getEmail());
            ps.setString(4, infoCustomerService.getPhone());
            ps.setInt(5, infoCustomerService.getMeter_no());
            boolean executedSuccessfully = ps.executeUpdate() > 0;
            ps.close();
            cons.close();
            return executedSuccessfully;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean exists(int meter_No) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "SELECT 1 FROM customer WHERE meter_No = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, meter_No);
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();
            rs.close();
            ps.close();
            cons.close();
            return exists;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        }
    @Override
    public boolean delete(int meter_No) {
        Connection cons = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cons = mysqlconnect.getConnection();
            String sqlDelete = "DELETE FROM customer WHERE meter_no = ?";
            ps = cons.prepareStatement(sqlDelete);
            ps.setInt(1, meter_No);
            boolean executedSuccessfully = ps.executeUpdate() > 0;
            ps.close();

            return executedSuccessfully;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cons != null) cons.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Customer> getListByUsername(String username) {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM customer WHERE user_id = (SELECT user_id FROM user WHERE username = ?)";
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer infoCustomerService = new Customer();
                infoCustomerService.setMeter_no(rs.getInt("meter_no"));
                infoCustomerService.setUser_id(rs.getInt("user_id"));
                infoCustomerService.setName(rs.getString("name"));
                infoCustomerService.setAddress(rs.getString("address"));
                infoCustomerService.setEmail(rs.getString("email"));
                infoCustomerService.setPhone(rs.getString("phone"));
                list.add(infoCustomerService);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        CustomerDao userDao = new CustomerDaoImpl();
        System.out.println(userDao.getList());
    }
}