/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.dao;

/**
 *
 * @author PC
 */
import fashion.store.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer, String> {
    // Có thể khai báo thêm các hàm đặc thù nếu cần
}