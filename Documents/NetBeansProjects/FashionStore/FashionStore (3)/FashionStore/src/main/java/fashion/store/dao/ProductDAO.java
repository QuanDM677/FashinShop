/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.dao;

import java.util.List;
import fashion.store.entity.Product;

/**
 *
 * @author PC
 */
public interface ProductDAO extends CrudDAO<Product, String>{ 
    List<Product> findByCategoryId(String categoryId); 
} 
