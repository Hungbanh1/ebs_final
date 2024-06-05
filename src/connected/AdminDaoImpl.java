
package connected;
import model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin login(String userName, String passWord) {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM admin WHERE username = ?";
        Admin accountAdmin = null;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hashedPasswordFromDB = rs.getString("password");
                if (HashingPassword.hashPassword(passWord).equals(hashedPasswordFromDB)) {
                    accountAdmin = new Admin();
                    accountAdmin.setUsername(rs.getString("username"));
                    accountAdmin.setPassword(hashedPasswordFromDB);
                }
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountAdmin;
    }

    @Override
    public boolean createOrUpdate(Admin accountAdmin) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "INSERT INTO admin (username, password) VALUES (?, ?) ON DUPLICATE KEY UPDATE username = VALUES(username), password = VALUES(password)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, accountAdmin.getUsername());
            String hashedPassword = HashingPassword.hashPassword(accountAdmin.getPassword());
            ps.setString(2, hashedPassword);
            int rowsAffected = ps.executeUpdate();

            ps.close();
            cons.close();

            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

