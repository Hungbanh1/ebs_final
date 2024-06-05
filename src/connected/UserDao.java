
package connected;
import model.User;
import java.util.List;
public interface UserDao {
    public User login(String username, String password);
    public boolean create(User accountCustomer);
    public boolean update(User accountCustomer);
    public boolean exists(String username);
    public int delete(int userId);
    public List<User> getList();
    public int getUserIdByUsername(String username);
}
