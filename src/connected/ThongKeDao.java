
package connected;
import model.Bill;
import java.util.List;
public interface ThongKeDao {
    List<Bill> getElectricConsumptionByMonth(int year);
    List<Bill> getElectricConsumptionByUserAndYear(String username, int year);
}
