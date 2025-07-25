/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.dao;

import java.util.Date;
import java.util.List;
import fashion.store.entity.Bill;

/**
 *
 * @author PC
 */
public interface BillDAO extends CrudDAO<Bill, Long> {

    List<Bill> findByUsername(String username);

    List<Bill> findByCustomerId(String customerId);

    List<Bill> findByTimeRange(Date begin, Date end);

    public Bill findServicingByCustomerId(String customerId);

    List<Bill> findByUserAndTimeRange(String username, Date begin, Date end);
}
