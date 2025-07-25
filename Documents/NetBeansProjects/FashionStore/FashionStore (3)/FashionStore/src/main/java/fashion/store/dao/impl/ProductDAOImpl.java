/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fashion.store.dao.impl;

import java.util.List;
import fashion.store.entity.Product;
import fashion.store.util.XJdbc;
import fashion.store.util.XQuery;
import fashion.store.dao.ProductDAO;

/**
 *
 * @author PC
 */
public class ProductDAOImpl implements ProductDAO {

    String createSql = "INSERT INTO Products (Id, Name, Image, UnitPrice, Discount, Available, CategoryId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Products SET Name=?, Image=?, UnitPrice=?, Discount=?, Available=?, CategoryId=? WHERE Id=?";
    String deleteSql = "DELETE FROM Products WHERE Id=?";
    String findAllSql = "SELECT * FROM Products";
    String findByIdSql = "SELECT * FROM Products WHERE Id=?";
    String findByCategoryIdSql = "SELECT * FROM Products WHERE CategoryId=?";

    @Override
    public Product create(Product entity) {
        Object[] values = {
            entity.getId(),
            entity.getName(),
            entity.getImage(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.isAvailable(),
            entity.getCategoryId()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Product entity) {
        Object[] values = {
            entity.getName(),
            entity.getImage(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.isAvailable(),
            entity.getCategoryId(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Product> findAll() {
        return XQuery.getBeanList(Product.class, findAllSql);
    }

    @Override
    public Product findById(String id) {
        return XQuery.getSingleBean(Product.class, findByIdSql, id);
    }

    @Override
    public List<Product> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(Product.class, findByCategoryIdSql, categoryId);
    }
}
