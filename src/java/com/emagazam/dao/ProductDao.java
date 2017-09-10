/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.dao;

import com.emagazam.model.Products;
import java.util.List;

/**
 *
 * @author ozaytunctan13
 */

public interface ProductDao {
    public boolean insertProduct(Products product);
    public boolean updateProduct(Products p);
    public List<Products> allProductList();
    public Products findProduct(Long id);
    public List<Products> findNameProduct(String productName);
    public boolean deleteProduct(Long id);
    
}
