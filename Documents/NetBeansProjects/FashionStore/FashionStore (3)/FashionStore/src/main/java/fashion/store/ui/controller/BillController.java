/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.ui.controller;

import fashion.store.entity.Bill;

/**
 *
 * @author PC
 */
public interface BillController {

    void setBill(Bill bill); // truyền bill vào cửa sổ để hiển thị 

    void open(); // Hiển thị bill 

    void close(); // Xóa bill nếu ko chứa san pham nào 

    void showProductJDialog(); // Hiển thị cửa sổ bổ sung san pham vào bill 

    void removeProducts(); // Xóa đồ uống khỏi bill 

    void updateQuantity(); // Thay đổi số lượng san pham 

    void checkout(); // Thanh toán 

    void cancel(); // Hủy bill 
}
