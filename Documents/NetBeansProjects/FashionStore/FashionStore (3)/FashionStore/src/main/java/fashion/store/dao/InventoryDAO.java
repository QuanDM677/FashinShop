/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.dao;

/**
 *
 * @author PC
 */
import fashion.store.entity.Inventory;

public interface InventoryDAO extends CrudDAO<Inventory, String> {
    // Có thể khai báo thêm các hàm như nhập/xuất kho, thống kê tồn kho...
}
