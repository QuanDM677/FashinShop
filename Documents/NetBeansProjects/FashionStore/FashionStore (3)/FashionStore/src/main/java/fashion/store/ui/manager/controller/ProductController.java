/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.ui.manager.controller;

import fashion.store.entity.Product;

/**
 *
 * @author PC
 */
public interface ProductController extends CrudController<Product> {

    void fillCategories();

    void chooseFile();
}
