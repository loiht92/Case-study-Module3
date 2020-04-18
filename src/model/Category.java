package model;

public class Category {
    //TODO: int >> Integer
    //category_id >> id
    private int id;
    private String name;
    private String status;

    public Category(){
    }

    public Category(String name, String status){
        this.name = name;
        this.status = status;
    }

    public Category(int id, String name, String status){
        super();
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
