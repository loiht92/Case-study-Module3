package service.BillDetails;

import model.BillDetails;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IBillDetails {
    public List<BillDetails> findAll(); //tra ve list danh sach;

    public void insert(BillDetails billDetails) throws SQLException; //Them moi san pham


    public boolean update(BillDetails billDetails) throws SQLException;

    public boolean remove(int id) throws SQLException;
}
