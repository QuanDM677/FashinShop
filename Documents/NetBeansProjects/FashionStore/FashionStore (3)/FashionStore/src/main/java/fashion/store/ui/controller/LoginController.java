/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.ui.controller;

import fashion.store.util.XDialog;

/**
 *
 * @author PC
 */
public interface LoginController {

    void open();

    void login();

    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }
}
