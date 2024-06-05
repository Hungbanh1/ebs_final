
package service;

import java.util.List;
import model.User;
public interface UserService {
    public User login(String username, String password);
    boolean create(User accountCustomer);
    boolean update(User accountCustomer);
    boolean exists(String username);
    public int delete(int userId);
    public List<User> getList();
    public int getUserIdByUsername(String username);
}
