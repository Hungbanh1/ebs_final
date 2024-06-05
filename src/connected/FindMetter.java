package connected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;
public class FindMetter {
    public Customer findCustomerByUsername(String username) {
        try {
            Connection connection = mysqlconnect.getConnection();
            String sql = "SELECT * FROM customer WHERE user_id = (SELECT user_id FROM user WHERE username = ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            Customer customerInfo = null;
            if (resultSet.next()) {
                customerInfo = new Customer();
                customerInfo.setMeter_no(resultSet.getInt("meter_no"));
                customerInfo.setName(resultSet.getString("name"));
                customerInfo.setAddress(resultSet.getString("address"));
                customerInfo.setEmail(resultSet.getString("email"));
                customerInfo.setPhone(resultSet.getString("phone"));
            }
            resultSet.close();
            statement.close();
            connection.close();
            return customerInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public Customer findCustomerByMeterNumber(int meterNumber) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "SELECT * FROM customer WHERE meter_no = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, meterNumber);
            ResultSet rs = ps.executeQuery();
            Customer customerInfo = null;
            if (rs.next()) {
                customerInfo = new Customer();
                customerInfo.setMeter_no(rs.getInt("meter_no"));
                customerInfo.setName(rs.getString("name"));
                customerInfo.setAddress(rs.getString("address"));
                customerInfo.setEmail(rs.getString("email"));
                customerInfo.setPhone(rs.getString("phone"));
            }
            rs.close();
            ps.close();
            cons.close();
            return customerInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
            FindMetter userDao = new FindMetter();
            System.out.println(userDao.findCustomerByUsername("user2004"));
        }

}
