
package model;


public class Tax {
    private float unit_price;
    private float service_charge;
    private float service_tax;
    private float fixed_tax;
    private int month;
    private int year;

    public Tax(float unit_price, float service_charge, float service_tax, float fixed_tax, int month, int year) {
        this.unit_price = unit_price;
        this.service_charge = service_charge;
        this.service_tax = service_tax;
        this.fixed_tax = fixed_tax;
        this.month = month;
        this.year = year;
    }
    public Tax() {
        this.unit_price = 0.0f;
        this.service_charge = 0.0f;
        this.service_tax = 0.0f;
        this.fixed_tax = 0.0f;
        this.month = 0;
        this.year = 0;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }
  

    public float getService_charge() {
        return service_charge;
    }

    public void setService_charge(float service_charge) {
        this.service_charge = service_charge;
    }

    public float getService_tax() {
        return service_tax;
    }

    public void setService_tax(float service_tax) {
        this.service_tax = service_tax;
    }

    public float getFixed_tax() {
        return fixed_tax;
    }

    public void setFixed_tax(float fixed_tax) {
        this.fixed_tax = fixed_tax;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
