/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.ui.controller;

import fashion.store.dao.BillDAO;
import fashion.store.dao.impl.BillDAOImpl;
import fashion.store.entity.Bill;
import fashion.store.ui.BillJDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import fashion.store.ui.ChangePasswordJDialog;
import fashion.store.ui.HistoryJDialog;
import fashion.store.ui.LoginJDialog;
import fashion.store.ui.WelcomeJDialog;
import fashion.store.ui.manager.BillManagerJDialog;
import fashion.store.ui.manager.CategoryManagerJDialog;
import fashion.store.ui.manager.ProductManagerJDialog;
import fashion.store.ui.manager.RevenueManagerJDialog;
import fashion.store.ui.manager.UserManagerJDialog;
import fashion.store.util.XDialog;
import fashion.store.ui.manager.CustomerManagerJDialog;
import fashion.store.ui.manager.InventoryManagerJDialog;


/**
 *
 * @author PC
 */
public interface FashionStoreController {

    /**
     * Hiển thị cửa sổ chào Hiển thị cửa sổ đăng nhập Hiển thị thông tin user
     * đăng nhập Disable/Enable các thành phần tùy thuộc vào vai trò đăng nhập
     */
    void init();

    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new LoginJDialog(frame, true));
    }

    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }

    default void showHistoryJDialog(JFrame frame) {
        this.showJDialog(new HistoryJDialog(frame, true));
    }

    default void showProductManagerJDialog(JFrame frame) {
        this.showJDialog(new ProductManagerJDialog(frame, true));
    }

    default void showCategoryManagerJDialog(JFrame frame) {
        this.showJDialog(new CategoryManagerJDialog(frame, true));
    }

    default void showBillManagerJDialog(JFrame frame) {
        this.showJDialog(new BillManagerJDialog(frame, true));
    }

    default void showUserManagerJDialog(JFrame frame) {
        this.showJDialog(new UserManagerJDialog(frame, true));
    }

    default void showRevenueManagerJDialog(JFrame frame) {
        this.showJDialog(new RevenueManagerJDialog(frame, true));
    }

    default void showCustomerManagerJDialog(JFrame frame) {
        this.showJDialog(new CustomerManagerJDialog(frame, true));
    }

    default void showInventoryManagerJDialog(JFrame frame) {
        this.showJDialog(new InventoryManagerJDialog(frame, true));
    }

    default void showBillJDialog(JFrame frame) {
        BillDAO billDao = new BillDAOImpl();
        Bill bill = billDao.findServicingByCustomerId("KH001"); // Hoặc lấy mã khách hàng động từ UI
        BillJDialog dialog = new BillJDialog(frame, true); // this là JFrame chính
        dialog.setBill(bill);
        dialog.setVisible(true);
    }
    

}
