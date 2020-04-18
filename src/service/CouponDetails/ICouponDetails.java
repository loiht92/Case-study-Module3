package service.CouponDetails;

import model.Coupon;
import model.CouponDetails;

import java.sql.SQLException;
import java.util.List;

public interface ICouponDetails {
    public List<CouponDetails> findAll(); //tra ve list danh sach;

    public void insert(CouponDetails couponDetails) throws SQLException; //Them moi san pham


    public boolean update(CouponDetails couponDetails) throws SQLException;

    public boolean remove(int id) throws SQLException;
}
