/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fashion.store.dao.impl;

/**
 *
 * @author PC
 */
import fashion.store.dao.InventoryDAO;
import fashion.store.entity.Inventory;
import fashion.store.util.XJdbc;
import fashion.store.util.XQuery;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {

    String createSql = "INSERT INTO Inventory(ProductId, Quantity) VALUES(?, ?)";
    String updateSql = "UPDATE Inventory SET Quantity=? WHERE ProductId=?";
    String deleteSql = "DELETE FROM Inventory WHERE ProductId=?";
    String findAllSql = "SELECT * FROM Inventory";
    String findByIdSql = "SELECT * FROM Inventory WHERE ProductId=?";

    @Override
    public Inventory create(Inventory entity) {
        Object[] values = {entity.getProductId(), entity.getQuantity()};
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Inventory entity) {
        Object[] values = {entity.getQuantity(), entity.getProductId()};
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Inventory> findAll() {
        return XQuery.getBeanList(Inventory.class, findAllSql);
    }

    @Override
    public Inventory findById(String id) {
        return XQuery.getSingleBean(Inventory.class, findByIdSql, id);
    }
}