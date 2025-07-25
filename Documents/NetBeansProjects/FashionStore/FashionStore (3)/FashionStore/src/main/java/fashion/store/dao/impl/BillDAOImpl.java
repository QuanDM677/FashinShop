package fashion.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import fashion.store.dao.BillDAO;
import fashion.store.entity.Bill;
import fashion.store.util.XAuth;
import fashion.store.util.XJdbc;
import fashion.store.util.XQuery;

/**
 *
 * @author PC
 */
public class BillDAOImpl implements BillDAO {

    String createSql = "INSERT INTO Bills(Username, Checkin, Checkout, Status, CustomerId) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Bills SET Username=?, Checkin=?, Checkout=?, Status=?, CustomerId=? WHERE Id=?";
    String deleteSql = "DELETE FROM Bills WHERE Id=?";
    String findAllSql = "SELECT * FROM Bills";
    String findByIdSql = "SELECT * FROM Bills WHERE Id=?";
    String findByUsernameSql = "SELECT * FROM Bills WHERE Username=?";
    String findByCustomerIdSql = "SELECT * FROM Bills WHERE CustomerId=?";
    String findByTimeRangeSql = "SELECT * FROM Bills WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";

    @Override
    public Bill create(Bill entity) {
        // Sửa: Lấy lại id tự tăng vừa tạo
        try (Connection con = XJdbc.openConnection(); PreparedStatement stmt = con.prepareStatement(createSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, entity.getUsername());
            stmt.setTimestamp(2, new java.sql.Timestamp(entity.getCheckin().getTime()));
            if (entity.getCheckout() != null) {
                stmt.setTimestamp(3, new java.sql.Timestamp(entity.getCheckout().getTime()));
            } else {
                stmt.setTimestamp(3, null);
            }
            stmt.setInt(4, entity.getStatus());
            stmt.setString(5, entity.getCustomerId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    entity.setId(rs.getLong(1));
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error when creating Bill: " + ex.getMessage(), ex);
        }
        return entity;
    }

    @Override
    public void update(Bill entity) {
        XJdbc.executeUpdate(updateSql, entity.getUsername(), entity.getCheckin(), entity.getCheckout(), entity.getStatus(), entity.getCustomerId(), entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Bill> findAll() {
        return XJdbc.getBeanList(Bill.class, findAllSql);
    }

    @Override
    public Bill findById(Long id) {
        List<Bill> list = XJdbc.getBeanList(Bill.class, findByIdSql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Bill> findByUsername(String username) {
        return XJdbc.getBeanList(Bill.class, findByUsernameSql, username);
    }

    @Override
    public List<Bill> findByCustomerId(String customerId) {
        return XJdbc.getBeanList(Bill.class, findByCustomerIdSql, customerId);
    }

    @Override
    public List<Bill> findByTimeRange(Date begin, Date end) {
        return XJdbc.getBeanList(Bill.class, findByTimeRangeSql, begin, end);
    }

    @Override
    public Bill findServicingByCustomerId(String customerId) {
        String sql = "SELECT * FROM Bills WHERE CustomerId=? AND Status=0";
        Bill bill = XQuery.getSingleBean(Bill.class, sql, customerId);
        if (bill == null) { // không tìm thấy -> tạo mới 
            Bill newBill = new Bill();
            newBill.setCheckin(new Date());
            newBill.setStatus(0); // đang phục vụ 
            newBill.setCustomerId(customerId);
            newBill.setUsername(XAuth.user.getUsername());
            bill = this.create(newBill); // insert, đã có id trả về
        }
        return bill;
    }

    @Override
    public List<Bill> findByUserAndTimeRange(String username, Date begin, Date end) {
        String sql = "SELECT * FROM Bills "
                + " WHERE Username=? AND Checkin BETWEEN ? AND ?";
        return XQuery.getBeanList(Bill.class, sql, username, begin, end);
    }
}
