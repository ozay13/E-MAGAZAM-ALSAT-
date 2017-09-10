/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.controller;

import com.emagazam.model.Categories;
import com.emagazam.model.Products;
import com.emagazam.service.CategoryDaoImplService;
import com.emagazam.service.ProductDaoImplService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class ProductManagerController {

    @Autowired
    ProductDaoImplService service;

    @ModelAttribute(value = "product")
    public Products createProduct() {
        return new Products();
    }

    @RequestMapping(value = "/")
    public ModelAndView indexPage() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("message", "Hoşgeldiniz......");
//        Products p = new Products();
//        p.setCategoryId(1L);
//        p.setProductName("Bisküvi");
//        p.setProductMarka("Ulker");
//        Date d = Calendar.getInstance().getTime();
//        p.setModifiedDate(d);
//        p.setCreationDate(d);
//        service.insertProduct(p);

        return mv;
    }

}
