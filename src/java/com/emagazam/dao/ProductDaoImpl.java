/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.dao;

import com.emagazam.model.Products;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ozaytunctan13
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    
    @Override
    public boolean insertProduct(Products product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean ret = true;
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.save(product);
            
        } catch (Exception e) {
            ret = false;
            ts.rollback();
            e.printStackTrace();
            
        }
        ts.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;
    }
    
    @Override
    public List<Products> allProductList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Products> list = new ArrayList<>();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            list = session.createQuery("from Products").list();
            
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
            
        }
        ts.commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }
    
    @Override
    public Products findProduct(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Products product = new Products();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            product = (Products) session.get(Products.class, id);
        } catch (Exception e) {
            session.beginTransaction().rollback();
            e.printStackTrace();
            
        }
        ts.commit();
        if (session.isOpen()) {
            session.close();
        }
        return product;
    }
    
    @Override
    public List<Products> findNameProduct(String productName) {
        List<Products> produtcs = allProductList();
        List<Products> filter = new ArrayList<>();
        for (Products produtc : produtcs) {
            if (produtc.getProductName().equals(productName)) {
                filter.add(produtc);
            }
        }
        return filter;
    }
    
    @Override
    public boolean deleteProduct(Long id) {
        Products p = findProduct(id);
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean ret = true;
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(p);
        } catch (Exception e) {
            ret = false;
            ts.rollback();
            e.printStackTrace();
            
        }
        ts.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;
    }
    
    @Override
    public boolean updateProduct(Products p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean ret = true;
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.saveOrUpdate(p);
            
        } catch (Exception e) {
            ret = false;
            ts.rollback();
            e.printStackTrace();
            
        }
        ts.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;
    }
    
}
