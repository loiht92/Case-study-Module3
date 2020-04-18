package model;

public class Coupon {
    int id;
    String import_date;

    public Coupon(){

    }

    public Coupon(int id, String import_date){
        this.id = id;
        this.import_date = import_date;
    }

    public Coupon(String import_date){
        this.import_date = import_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImport_date() {
        return import_date;
    }

    public void setImport_date(String import_date) {
        this.import_date = import_date;
    }
}
