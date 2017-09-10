/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.service;

import com.emagazam.model.Products;
import java.util.List;

/**
 *
 * @author ozaytunctan13
 */
public interface ProductDaoService {

    public boolean insertProduct(Products product);

    public List<Products> allProductList();

    public Products findProduct(Long id);

    public List<Products> findProduct(String productName);

    public boolean deleteProduct(Long id);
    public boolean updateProduct(Products id);
}
