/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.dao;

import com.emagazam.model.Brands;
import com.emagazam.model.Categories;
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
public class BrandsDaoImpl implements BrandsDao {

    @Override
    public boolean insertBrand(Brands c) {
        Session session = null;
        Transaction trs = null;
        boolean ret = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trs = session.beginTransaction();
            session.save(c);

        } catch (Exception e) {
            ret = false;
            trs.rollback();
            e.printStackTrace();
        }
//        } finally {
//            session.close();
//        }
        trs.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;

    }

    @Override
    public boolean updateBrand(Brands c
    ) {
        Session session = null;
        Transaction trs = null;
        boolean ret = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trs = session.beginTransaction();
            session.saveOrUpdate(c);

        } catch (Exception e) {
            ret = false;
            trs.rollback();
            e.printStackTrace();
        }
//        } finally {
//            session.close();
//        }
        trs.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;

    }

    @Override
    public boolean deleteBrand(Long id) {
        Session session = null;
        Transaction trs = null;
        boolean ret = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trs = session.beginTransaction();
            Brands c = (Brands) findBrandId(id);
            session.delete(c);

        } catch (Exception e) {
            ret = false;
            trs.rollback();
            e.printStackTrace();
        }
//        } finally {
//            session.close();
//        }
        trs.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;

    }

    @Override
    public Brands findBrandId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Brands product = new Brands();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            product = (Brands) session.get(Brands.class, id);
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();

        }
        ts.commit();
        if (session.isOpen()) {
            session.close();
        }
        return product;
    }

    @Override
    public List<Brands> allBrandList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        List<Brands> list = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            list = session.createQuery("from Brands").list();
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

}
