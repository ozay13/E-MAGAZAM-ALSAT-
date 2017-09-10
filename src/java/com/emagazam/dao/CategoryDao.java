/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.dao;

import com.emagazam.model.Categories;
import java.util.List;

/**
 *
 * @author ozaytunctan13
 */
public interface CategoryDao {
    public boolean insertCategory(Categories c);
    public boolean updateCategory(Categories c);
    public boolean deleteCategory(Long id);
    public Categories findCategoryId(Long id);
    public List<Categories>allCategoryList();
}
