package connected;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Tax;

public class TaxDaoImpl implements TaxDao{

    @Override
    public Tax getTaxInfo() {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM tax";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tax tax = new Tax();
                tax.setUnit_price(rs.getFloat("unit_price"));
                tax.setService_charge(rs.getFloat("service_charge"));
                tax.setService_tax(rs.getFloat("service_tax"));
                tax.setFixed_tax(rs.getFloat("fixed_tax"));
                tax.setMonth(rs.getInt("month"));
                tax.setYear(rs.getInt("year"));
                ps.close();
                rs.close();
                cons.close();
                return tax;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean createTaxInfo(Tax tax) {
        Connection cons = mysqlconnect.getConnection();
        String sql = "INSERT INTO tax (unit_price, service_charge, service_tax, fixed_tax, month, year) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setFloat(1, tax.getUnit_price());
            ps.setFloat(2, tax.getService_charge());
            ps.setFloat(3, tax.getService_tax());
            ps.setFloat(4, tax.getFixed_tax());
            ps.setInt(5, tax.getMonth());
            ps.setInt(6, tax.getYear());

            int rowsAffected = ps.executeUpdate();

            ps.close();
            cons.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateTaxInfo(Tax tax) {
        Connection cons = mysqlconnect.getConnection();
        String sql = "UPDATE tax SET unit_price = ?, service_charge = ?, service_tax = ?, fixed_tax = ? "
                   + "WHERE month = ? AND year = ?";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setFloat(1, tax.getUnit_price());
            ps.setFloat(2, tax.getService_charge());
            ps.setFloat(3, tax.getService_tax());
            ps.setFloat(4, tax.getFixed_tax());
            ps.setInt(5, tax.getMonth());
            ps.setInt(6, tax.getYear());

            int rowsAffected = ps.executeUpdate();
            ps.close();
            cons.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Tax getTaxInfoByMonthAndYear(int month, int year) {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM tax WHERE month = ? AND year = ?";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tax tax = new Tax();
                tax.setUnit_price(rs.getFloat("unit_price"));
                tax.setService_charge(rs.getFloat("service_charge"));
                tax.setService_tax(rs.getFloat("service_tax"));
                tax.setFixed_tax(rs.getFloat("fixed_tax"));
                tax.setMonth(rs.getInt("month"));
                tax.setYear(rs.getInt("year"));
                ps.close();
                rs.close();
                cons.close();
                return tax;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean exists(int month, int year) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "SELECT 1 FROM tax WHERE month = ? AND year = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
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


}
