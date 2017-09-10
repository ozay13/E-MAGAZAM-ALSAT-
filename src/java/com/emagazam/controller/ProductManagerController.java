/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.controller;

import com.emagazam.model.Brands;
import com.emagazam.model.Categories;
import com.emagazam.model.Products;
import com.emagazam.service.BrandsDaoImplService;
import com.emagazam.service.CategoryDaoImplService;
import com.emagazam.service.ProductDaoImplService;
import com.emagazam.validator.EmailValidator;
import com.emagazam.validator.ProductsValidator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    @Autowired
    BrandsDaoImplService brandService;
    @Autowired
    CategoryDaoImplService categoryService;
    @Autowired
    EmailValidator emailValidator;
    @Autowired
    ProductsValidator productValidator;

    @ModelAttribute(value = "product")
    public Products createProduct() {
        return new Products();
    }

    @ModelAttribute(value = "categoryList")
    public HashMap<Long, String> createCategoryList() {
        HashMap<Long, String> m = new HashMap<>();
        List<Categories> list = categoryService.allCategoryList();
        for (Categories categories : list) {
            m.put(categories.getId(), categories.getCategoryName());
        }
        return m;
    }

    @ModelAttribute(value = "brandList")
    public HashMap<Long, String> createBrandList() {
        HashMap<Long, String> m = new HashMap<>();
        List<Brands> list = brandService.allBrandList();
        for (Brands categories : list) {
            m.put(categories.getId(), categories.getBrandName());
        }
        return m;
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(emailValidator, productValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Products.class, "creationDate", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/")
    public ModelAndView indexPage() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("message", "Hoşgeldiniz......");
        return mv;
    }

    @RequestMapping(value = "/newProduct")
    public ModelAndView newProduct(@ModelAttribute("product") @Validated Products product, BindingResult error) {
        return new ModelAndView("newProduct");
    }

}
