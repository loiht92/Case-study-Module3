package model;

public class Bill {
    int id;
    String export_date;
    String customer_name;

    public Bill(){

    }

    public Bill(int id, String export_date, String customer_name){
        this.id = id;
        this.export_date = export_date;
        this.customer_name = customer_name;
    }

    public Bill(String export_date, String customer_name){
        this.export_date = export_date;
        this.customer_name = customer_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExport_date() {
        return export_date;
    }

    public void setExport_date(String export_date) {
        this.export_date = export_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
