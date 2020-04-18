package model;

public class BillDetails {
    int id;
    int number_export;
    float export_price;

    public BillDetails(){

    }

    public BillDetails(int id, int number_export, float export_price){
        this.id = id;
        this.number_export = number_export;
        this.export_price = export_price;
    }

    public BillDetails(int number_export, float export_price){
        this.number_export = number_export;
        this.export_price = export_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_export() {
        return number_export;
    }

    public void setNumber_export(int number_export) {
        this.number_export = number_export;
    }

    public float getExport_price() {
        return export_price;
    }

    public void setExport_price(float export_price) {
        this.export_price = export_price;
    }
}
