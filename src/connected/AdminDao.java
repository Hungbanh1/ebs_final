
package connected;
import model.Admin;

public interface AdminDao {
    public Admin login(String username, String password);
    public boolean createOrUpdate(Admin accountAdmin);
}
