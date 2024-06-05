package connected;
import model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

    @Override
    public List<Bill> getList() {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM bill";
        List<Bill> list = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setMeter_no(rs.getInt("meter_no"));
                bill.setMonth(rs.getInt("month"));
                bill.setYear(rs.getInt("year"));
                bill.setUnits(rs.getInt("units"));
                bill.setTotal_bill(rs.getFloat("totalbill"));
                bill.setStatus(rs.getString("status"));
                bill.setDate(rs.getDate("date"));
                list.add(bill);
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
    public int create(Bill bill) {
        try {
            Connection cons = mysqlconnect.getConnection();

            // Kiểm tra xem hóa đơn đã tồn tại chưa
            String checkSql = "SELECT id FROM bill WHERE meter_no = ? AND month = ? AND year = ?";
            PreparedStatement checkPs = cons.prepareStatement(checkSql);
            checkPs.setInt(1, bill.getMeter_no());
            checkPs.setInt(2, bill.getMonth());
            checkPs.setInt(3, bill.getYear());
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String updateSql = "UPDATE bill SET units = ?, totalbill = ?, status = ?, date = CURRENT_TIMESTAMP WHERE id = ?";
                PreparedStatement updatePs = cons.prepareStatement(updateSql);
                updatePs.setInt(1, bill.getUnits());
                updatePs.setFloat(2, bill.getTotal_bill());
                updatePs.setString(3, bill.getStatus());
                updatePs.setInt(4, id);
                updatePs.executeUpdate();
                updatePs.close();
                rs.close();
                checkPs.close();
                cons.close();
                return id;
            } else {
                // Nếu không tồn tại, tạo mới bản ghi
                String insertSql = "INSERT INTO bill (meter_no, month, year, units, totalbill, status, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertPs = cons.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);
                insertPs.setInt(1, bill.getMeter_no());
                insertPs.setInt(2, bill.getMonth());
                insertPs.setInt(3, bill.getYear());
                insertPs.setInt(4, bill.getUnits());
                insertPs.setFloat(5, bill.getTotal_bill());
                insertPs.setString(6, bill.getStatus());
                insertPs.setNull(7, java.sql.Types.DATE);
                insertPs.execute();
                ResultSet generatedKeys = insertPs.getGeneratedKeys();
                int generatedKey = 0;
                if (generatedKeys.next()) {
                    generatedKey = generatedKeys.getInt(1);
                }
                insertPs.close();
                rs.close();
                checkPs.close();
                updateBillIds(cons);
                cons.close();
                return generatedKey;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Bill> getBillByFilters(String username, Integer meterNo, Integer month, Integer year) {
        List<Bill> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT b.* FROM bill b");
        List<Object> parameters = new ArrayList<>();

        boolean hasUsername = username != null && !username.isEmpty();
        if (hasUsername) {
            sql.append(" JOIN customer c ON b.meter_no = c.meter_no JOIN user u ON c.user_id = u.user_id WHERE u.username = ?");
            parameters.add(username);
        } else {
            sql.append(" WHERE 1=1");
        }

        if (meterNo != null) {
            sql.append(" AND b.meter_no = ?");
            parameters.add(meterNo);
        }
        if (month != null) {
            sql.append(" AND b.month = ?");
            parameters.add(month);
        }
        if (year != null) {
            sql.append(" AND b.year = ?");
            parameters.add(year);
        }

        try (Connection cons = mysqlconnect.getConnection();
             PreparedStatement ps = cons.prepareStatement(sql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                ps.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setId(rs.getInt("id"));
                    bill.setMeter_no(rs.getInt("meter_no"));
                    bill.setMonth(rs.getInt("month"));
                    bill.setYear(rs.getInt("year"));
                    bill.setUnits(rs.getInt("units"));
                    bill.setTotal_bill(rs.getFloat("totalbill"));
                    bill.setStatus(rs.getString("status"));
                    bill.setDate(rs.getDate("date"));
                    list.add(bill);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Bill> getBillByUsername(String username) {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT b.* FROM bill b " +
                     "JOIN customer c ON b.meter_no = c.meter_no " +
                     "JOIN user u ON c.user_id = u.user_id " +
                     "WHERE u.username = ?";
        try (Connection cons = mysqlconnect.getConnection();
             PreparedStatement ps = cons.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setId(rs.getInt("id"));
                    bill.setMeter_no(rs.getInt("meter_no"));
                    bill.setMonth(rs.getInt("month"));
                    bill.setYear(rs.getInt("year"));
                    bill.setUnits(rs.getInt("units"));
                    bill.setTotal_bill(rs.getFloat("totalbill"));
                    bill.setStatus(rs.getString("status"));
                    bill.setDate(rs.getDate("date"));
                    list.add(bill);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public boolean delete(int id) {
        String deleteSql = "DELETE FROM bill WHERE id = ?";
        
        try (Connection cons = mysqlconnect.getConnection();
             PreparedStatement deletePs = cons.prepareStatement(deleteSql)) {

            deletePs.setInt(1, id);
            int affectedRows = deletePs.executeUpdate();
            if (affectedRows > 0) {
                updateBillIds(cons);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private void updateBillIds(Connection cons) throws Exception {
        String selectSql = "SELECT id FROM bill ORDER BY id";
        String updateSql = "UPDATE bill SET id = ? WHERE id = ?";

        try (PreparedStatement selectPs = cons.prepareStatement(selectSql);
             ResultSet rs = selectPs.executeQuery()) {

            int newId = 1;
            while (rs.next()) {
                int currentId = rs.getInt("id");
                if (currentId != newId) {
                    try (PreparedStatement updatePs = cons.prepareStatement(updateSql)) {
                        updatePs.setInt(1, newId);
                        updatePs.setInt(2, currentId);
                        updatePs.executeUpdate();
                    }
                }
                newId++;
            }
        }
    }

}
