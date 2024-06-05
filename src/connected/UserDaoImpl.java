
package connected;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class UserDaoImpl implements UserDao{
    @Override
    public User login(String userName, String passWord) {
        Connection cons = mysqlconnect.getConnection();
        String sql = "SELECT * FROM user WHERE username = ?";
        User accountUser = null;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hashedPasswordFromDB = rs.getString("password");
                if (HashingPassword.hashPassword(passWord).equals(hashedPasswordFromDB)) {
                    accountUser = new User();
                    accountUser.setUsername(rs.getString("username"));
                    accountUser.setPassword(hashedPasswordFromDB); // Store hashed password
                    accountUser.setName(rs.getString("name"));
                }
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountUser;
    }
    @Override
    public boolean create(User accountCustomer) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "INSERT INTO user (username, name, password) VALUES (?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, accountCustomer.getUsername());
            ps.setString(2, accountCustomer.getName());
            String hashedPassword = HashingPassword.hashPassword(accountCustomer.getPassword());
            ps.setString(3, hashedPassword);
            int rowsAffected = ps.executeUpdate();

            ps.close();
            if (rowsAffected > 0) {
                updateUserIds(cons); // Update user IDs after insertion
            }
            cons.close();

            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean update(User accountCustomer) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "UPDATE user SET username = ?, name = ?, password = ? WHERE username = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, accountCustomer.getUsername());
            ps.setString(2, accountCustomer.getName());
            String hashedPassword = HashingPassword.hashPassword(accountCustomer.getPassword());
            ps.setString(3, hashedPassword);
            ps.setString(4, accountCustomer.getUsername());

            int rowsAffected = ps.executeUpdate();

            ps.close();
            cons.close();

            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exists(String username) {
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "SELECT 1 FROM user WHERE username = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, username);
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
    public int delete(int userId) {
        Connection cons = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cons = mysqlconnect.getConnection();

            // Delete user
            String sqlDelete = "DELETE FROM user WHERE user_id = ?";
            ps = cons.prepareStatement(sqlDelete);
            ps.setInt(1, userId);
            int rowsDeleted = ps.executeUpdate();
            ps.close();

            if (rowsDeleted > 0) {
                updateUserIds(cons); // Update user IDs after deletion
            }
            return rowsDeleted;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
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
    public List<User> getList() {
        List<User> userList = new ArrayList<>();
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "SELECT * FROM user";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    @Override
    public int getUserIdByUsername(String username) {
        int userId = -1; // Initialize with a default value indicating failure
        try {
            Connection cons = mysqlconnect.getConnection();
            String sql = "SELECT user_id FROM user WHERE username = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userId;
    }
    private void updateUserIds(Connection cons) throws Exception {
        String selectSql = "SELECT user_id FROM user ORDER BY user_id";
        String updateSql = "UPDATE user SET user_id = ? WHERE user_id = ?";

        try (PreparedStatement selectPs = cons.prepareStatement(selectSql);
             ResultSet rs = selectPs.executeQuery()) {

            int newId = 1;
            while (rs.next()) {
                int currentId = rs.getInt("user_id");
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
