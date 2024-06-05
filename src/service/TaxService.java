
package service;
import model.Tax;

public interface TaxService {
    Tax getTaxInfo();
    boolean createTaxInfo(Tax tax);
    boolean updateTaxInfo(Tax tax);
    Tax getTaxInfoByMonthAndYear(int month, int year);
    boolean exists(int month, int year);
}
