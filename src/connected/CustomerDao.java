
package connected;

import model.Customer;
import java.util.List;

public interface CustomerDao {
    public List<Customer> getList();
    public boolean create(Customer infoCustomerService);
    public boolean update(Customer infoCustomerService);
    public boolean exists(int meter_No);
    public boolean delete(int meter_No);
    List<Customer> getListByUsername(String username);

}
