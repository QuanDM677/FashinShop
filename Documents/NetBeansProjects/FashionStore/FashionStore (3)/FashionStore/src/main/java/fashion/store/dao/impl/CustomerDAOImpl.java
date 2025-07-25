package fashion.store.dao.impl;

import fashion.store.dao.CustomerDAO;
import fashion.store.entity.Customer;
import fashion.store.util.XJdbc;
import fashion.store.util.XQuery;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    String createSql = "INSERT INTO Customers(Id, Name, Phone, Address, Enabled) VALUES(?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Customers SET Name=?, Phone=?, Address=?, Enabled=? WHERE Id=?";
    String deleteSql = "DELETE FROM Customers WHERE Id=?";
    String findAllSql = "SELECT * FROM Customers";
    String findByIdSql = "SELECT * FROM Customers WHERE Id=?";

    public Customer create(Customer entity) {
        Object[] values = {entity.getId(), entity.getName(), entity.getPhone(), entity.getAddress(), entity.isEnabled()};
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    public void update(Customer entity) {
        Object[] values = {entity.getName(), entity.getPhone(), entity.getAddress(), entity.isEnabled(), entity.getId()};
        XJdbc.executeUpdate(updateSql, values);
    }

    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    public List<Customer> findAll() {
        return XQuery.getBeanList(Customer.class, findAllSql);
    }

    public Customer findById(String id) {
        return XQuery.getSingleBean(Customer.class, findByIdSql, id);
    }
}