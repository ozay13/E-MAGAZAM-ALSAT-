/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.dao;

import com.emagazam.model.Categories;
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
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean insertCategory(Categories c) {
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
    public boolean updateCategory(Categories c
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
    public boolean deleteCategory(Long id
    ) {
        Session session = null;
        Transaction trs = null;
        boolean ret = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trs = session.beginTransaction();
            Categories c = (Categories) findCategoryId(id);
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
    public Categories findCategoryId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Categories product = new Categories();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            product = (Categories) session.get(Categories.class, id);
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
    public List<Categories> allCategoryList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        List<Categories> list = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            list = session.createQuery("from Categories").list();
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
