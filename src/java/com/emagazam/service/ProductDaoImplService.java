/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.service;


import com.emagazam.dao.ProductDaoImpl;
import com.emagazam.model.Products;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ozaytunctan13
 */
@Service
public class ProductDaoImplService implements ProductDaoService {
    
    @Autowired
    ProductDaoImpl productDao;
    

    @Transactional
    @Override
    public boolean insertProduct(Products product) {
        return productDao.insertProduct(product);
    }
    

    @Transactional
    @Override
    public List<Products> allProductList() {
        return productDao.allProductList();
    }
    
    @Override
    @Transactional
    public Products findProduct(Long id) {
        return productDao.findProduct(id);
    }
   
    @Transactional
    @Override
    public List<Products> findProduct(String productName) {
        return productDao.findNameProduct(productName);
    }

    @Transactional
    @Override
    public boolean deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }
    
}
