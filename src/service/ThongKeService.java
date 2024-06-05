
package service;

import java.util.List;
import model.Bill;
public interface ThongKeService {
    List<Bill> getElectricConsumptionByMonth(int year);
    List<Bill> getElectricConsumptionByUserAndYear(String username, int year);
}
