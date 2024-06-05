
package service;
import java.util.List;
import model.Bill;
public interface BillService {
    public List<Bill> getList();
    public int create(Bill bill);
    public List<Integer> getUnitsByMeterNo(int meterNo);
    List<Bill> getBillByFilters(String username, Integer meterNo, Integer month, Integer year);
    List<Bill> getBillByUsername(String username);
    public boolean delete(int id);
}
