package service.Coupon;

import model.Coupon;

import java.sql.SQLException;
import java.util.List;

public interface ICoupon {
    public List<Coupon> findAll(); //tra ve list danh sach;

    public void insert(Coupon coupon) throws SQLException; //Them moi san pham


    public boolean update(Coupon coupon) throws SQLException;

    public boolean remove(int id) throws SQLException;
}
