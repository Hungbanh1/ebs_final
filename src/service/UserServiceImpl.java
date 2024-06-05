package service;

import connected.UserDaoImpl;
import model.User;
import connected.UserDao;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao accountCustomerDao = null;

    public UserServiceImpl() {
        // tao doi tuong 
        accountCustomerDao = new UserDaoImpl();
    }

    @Override
    public User login(String username, String password) {
        return accountCustomerDao.login(username, password);
    }

    @Override
    public boolean create(User accountCustomer) {
        return accountCustomerDao.create(accountCustomer);
    }
    @Override
    public boolean update(User accountCustomer) {
        return accountCustomerDao.update(accountCustomer);
    }
    @Override
    public boolean exists(String username) {
        return accountCustomerDao.exists(username);
    }
    @Override
    public int delete(int userId) {
        return accountCustomerDao.delete(userId);
    }
    @Override
    public List<User> getList() {
        return accountCustomerDao.getList();
    }
    @Override
    public int getUserIdByUsername(String username) {
        return accountCustomerDao.getUserIdByUsername(username);
    }
}
