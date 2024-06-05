package service;

import java.util.List;
import model.Bill;
import connected.ThongKeDao;
import connected.ThongKeDaoImpl;
public class ThongKeServiceImpl implements ThongKeService {
    private ThongKeDao thongKeDao;

    public ThongKeServiceImpl() {
        thongKeDao = new ThongKeDaoImpl();
    }

    @Override
    public List<Bill> getElectricConsumptionByMonth(int year) {
        return thongKeDao.getElectricConsumptionByMonth(year);
    }
    @Override
    public List<Bill> getElectricConsumptionByUserAndYear(String username, int year) {
        return thongKeDao.getElectricConsumptionByUserAndYear(username, year);
    }
}
