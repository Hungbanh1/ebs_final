
package service;

import model.Admin;

public interface AdminService {
    public Admin login(String username, String password);
    public boolean createOrUpdate(Admin accounAdmin);
}
