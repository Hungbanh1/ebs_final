
package service;

import java.util.List;
import model.Customer;

public interface CustomerService {
    public List<Customer> getList();
    boolean create(Customer infoCustomerService);
    boolean update(Customer infoCustomerService);
    boolean exists(int meter_No);
    public List<Customer> getListByUsername(String username);
    public Customer findCustomerByMeterNumber(int metterNumber);
    public List<Integer> getMeterNumbers(String username);
    public boolean delete(int meter_No);
    public int RandomMeter_no();
}
