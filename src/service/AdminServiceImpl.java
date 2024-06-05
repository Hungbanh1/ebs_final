package service;

import connected.AdminDaoImpl;
import model.Admin;
import connected.AdminDao;

public class AdminServiceImpl implements AdminService {
    private AdminDao accountAdminDao = null;

    public AdminServiceImpl() {
        accountAdminDao = new AdminDaoImpl();
    }

    @Override
    public Admin login(String username, String password) {
        return accountAdminDao.login(username, password);
    }

    @Override
    public boolean createOrUpdate(Admin accountAdmin) {
        return accountAdminDao.createOrUpdate(accountAdmin);
    }

}
