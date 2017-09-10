/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.controller;

import com.emagazam.model.Categories;
import com.emagazam.service.CategoryDaoImplService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ozaytunctan13
 */
@Controller
public class CategoryManagerController {

    @Autowired
    CategoryDaoImplService categoryService;
      
    @ModelAttribute(value = "categoryList")
    public HashMap<Long,String> createCategoryList() {
        HashMap<Long,String> m = new HashMap<>();
        List<Categories> list = categoryService.allCategoryList();
        for (Categories categories : list) {
            m.put(categories.getId(),categories.getCategoryName());
            
        }
        return m;
    }
    @RequestMapping(value = "/newCategory")
    public ModelAndView newCategory(){
        return new ModelAndView("category");
    }
}
