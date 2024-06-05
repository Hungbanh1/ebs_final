package connected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Bill;


public class ThongKeDaoImpl implements ThongKeDao {

    @Override
    public List<Bill> getElectricConsumptionByMonth(int year) {
        List<Bill> electricConsumptionByMonth = new ArrayList<>();
        try {
            Connection conn = mysqlconnect.getConnection();

            String sql = "SELECT month, COUNT(*) AS count, SUM(units) AS units " +
                         "FROM bill " +
                         "WHERE year = ? " +
                         "GROUP BY month";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int month = rs.getInt("month");
                int count = rs.getInt("count");
                int units = rs.getInt("units");

                Bill bill = new Bill();
                bill.setMonth(month);
                bill.setCount(count);
                bill.setUnits(units);
                electricConsumptionByMonth.add(bill);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return electricConsumptionByMonth;
    }
    @Override
    public List<Bill> getElectricConsumptionByUserAndYear(String username, int year) {
        List<Bill> electricConsumptionByMonth = new ArrayList<>();
        try {
            Connection conn = mysqlconnect.getConnection();

            String sql = "SELECT b.month, COUNT(*) AS count, SUM(b.units) AS units " +
                         "FROM bill b " +
                         "JOIN customer c ON b.meter_no = c.meter_no " +
                         "JOIN user u ON c.user_id = u.user_id " +
                         "WHERE u.username = ? AND b.year = ? " +
                         "GROUP BY b.month";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int month = rs.getInt("month");
                int count = rs.getInt("count");
                int units = rs.getInt("units");

                Bill bill = new Bill();
                bill.setMonth(month);
                bill.setCount(count);
                bill.setUnits(units);
                electricConsumptionByMonth.add(bill);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return electricConsumptionByMonth;
    }

   
}
