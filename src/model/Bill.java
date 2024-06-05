package model;

import java.util.Date;

public class Bill {
    private int id;
    private int meter_no;
    private int month;
    private int year;
    private int units;
    private float total_bill;
    private String status;
    private Date date;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeter_no() {
        return meter_no;
    }

    public void setMeter_no(int meter_no) {
        this.meter_no = meter_no;
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

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public float getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(float total_bill) {
        this.total_bill = total_bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
