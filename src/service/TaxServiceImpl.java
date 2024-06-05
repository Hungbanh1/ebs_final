package service;

import connected.TaxDao;
import connected.TaxDaoImpl;
import model.Tax;

public class TaxServiceImpl implements TaxService {
    private TaxDao taxDao;

    public TaxServiceImpl() {
        taxDao = new TaxDaoImpl();
    }

    @Override
    public Tax getTaxInfo() {
        return taxDao.getTaxInfo();
    }

    @Override
    public boolean createTaxInfo(Tax tax) {
        return taxDao.createTaxInfo(tax);
    }
    @Override
    public boolean updateTaxInfo(Tax tax) {
        return taxDao.updateTaxInfo(tax);
    }
    @Override
    public Tax getTaxInfoByMonthAndYear(int month, int year){
        return taxDao.getTaxInfoByMonthAndYear(month, year);
    }
    @Override
    public boolean exists(int month, int year){
        return taxDao.exists(month, year);
    }
}
