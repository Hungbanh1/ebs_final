package service;

import connected.CustomerDaoImpl;
import model.Customer;
import java.util.List;
import connected.FindMetter;
import java.util.ArrayList;
import connected.CustomerDao;
import java.util.Random;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao InfoCustomerDao;
    private FindMetter findMetter;

    public CustomerServiceImpl() {
        InfoCustomerDao = new CustomerDaoImpl();
        findMetter = new FindMetter();
    }

    @Override
    public List<Customer> getList() {
        return InfoCustomerDao.getList();
    }

    @Override
    public boolean create(Customer user) {
        return InfoCustomerDao.create(user);
    }
    @Override
    public boolean update(Customer user) {
        return InfoCustomerDao.update(user);
    }
    @Override
    public boolean exists(int meter_No) {
        return InfoCustomerDao.exists(meter_No);
    }
    @Override
    public List<Customer> getListByUsername(String username) {
        return InfoCustomerDao.getListByUsername(username);
    }
    @Override
    public Customer findCustomerByMeterNumber(int metterNumber){
        return findMetter.findCustomerByMeterNumber(metterNumber);
    }
    @Override
    public List<Integer> getMeterNumbers(String username) {
        List<Customer> customerList = InfoCustomerDao.getListByUsername(username);
        List<Integer> meterNumbers = new ArrayList<>();
        for (Customer customer : customerList) {
            meterNumbers.add(customer.getMeter_no());
        }
        return meterNumbers;
    }
    
    @Override
    public boolean delete(int meter_No) {
        return InfoCustomerDao.delete(meter_No);
    }
    @Override
    public int RandomMeter_no() {
        Random random = new Random();
        int randomSixDigits = random.nextInt(900000) + 100000;
        String meterNoStr = "19" + randomSixDigits;
        int randomMeterNo = Integer.parseInt(meterNoStr);
        return randomMeterNo;
    }
}
