
package connected;
import model.Bill;
import java.util.List;
public interface BillDao {
    public List<Bill> getList();
    public int create(Bill bill);
    List<Bill> getBillByFilters(String username, Integer meterNo, Integer month, Integer year);
    List<Bill> getBillByUsername(String username);
    public boolean delete(int id);
}
