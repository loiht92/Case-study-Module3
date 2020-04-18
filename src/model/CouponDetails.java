package model;

public class CouponDetails {
    int id;
    int number_import;
    float import_price;

    public CouponDetails(){

    }

    public CouponDetails(int id, int number_import, float import_price){
        this.id = id;
        this.number_import = number_import;
        this.import_price = import_price;
    }

    public CouponDetails(int number_import, float import_price){
        this.number_import = number_import;
        this.import_price = import_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_import() {
        return number_import;
    }

    public void setNumber_import(int number_import) {
        this.number_import = number_import;
    }

    public float getImport_price() {
        return import_price;
    }

    public void setImport_price(float import_price) {
        this.import_price = import_price;
    }
}
