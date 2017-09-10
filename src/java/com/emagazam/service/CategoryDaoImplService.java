/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.service;

import com.emagazam.dao.CategoryDao;
import com.emagazam.dao.CategoryDaoImpl;
import com.emagazam.model.Categories;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ozaytunctan13
 */
@Service
public class CategoryDaoImplService implements CategoryDao {

    @Autowired
    CategoryDaoImpl dao;

    @Override
    @Transactional
    public boolean insertCategory(Categories c) {
        return dao.insertCategory(c);
    }

    @Override
    @Transactional
    public boolean updateCategory(Categories c) {
        return dao.updateCategory(c);
    }

    @Override
    @Transactional
    public boolean deleteCategory(Long id) {
        return dao.deleteCategory(id);
    }

    @Override
    @Transactional
    public Categories findCategoryId(Long id) {
        return dao.findCategoryId(id);
    }

    @Override
    @Transactional
    public List<Categories> allCategoryList() {
        return dao.allCategoryList();
    }

}
