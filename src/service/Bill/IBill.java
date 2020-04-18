package service.Bill;

import model.Bill;
import model.Coupon;

import java.sql.SQLException;
import java.util.List;

public interface IBill {
    public List<Bill> findAll(); //tra ve list danh sach;

    public void insert(Bill bill) throws SQLException; //Them moi san pham


    public boolean update(Bill bill) throws SQLException;

    public boolean remove(int id) throws SQLException;
}
