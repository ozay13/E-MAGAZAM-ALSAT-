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
import java.text.DateFormat;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ozaytunctan13
 */
@Controller
public class ProductManagerController {

    @Autowired
    ProductDaoImplService productService;
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
        for (Brands b : list) {
            m.put(b.getId(), b.getBrandName());
        }
        return m;
    }

    @ModelAttribute(value = "productList")
    public List<Products> createProductList() {
        HashMap<Long, String> m = new HashMap<>();
        
        List<Products> list = productService.allProductList();
        return list;

    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
//        binder.addValidators(emailValidator, productValidator);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Products.class, "creationDate", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/home")
    public ModelAndView indexPage() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("message", "Hoşgeldiniz......");
        return mv;
    }

    @RequestMapping(value = "/product")
    public String showPageProduct() {
        return "newProduct";
    }

    @RequestMapping(value = "/newProduct",method =RequestMethod.POST)
    public ModelAndView newProduct(@ModelAttribute("product") @Validated Products product, BindingResult error) {
        ModelAndView mv = null;
        if (error.hasErrors()) {
            mv = new ModelAndView("redirect:/error");

        } else {
            product.setModifiedDate(Calendar.getInstance().getTime());
            boolean ret = productService.insertProduct(product);
            if (ret) {
                mv = new ModelAndView("newProduct");
                mv.addObject("result", "Ürün Ekleme Başarılı");
                return mv;
            } else {
                mv = new ModelAndView("newProduct");
                mv.addObject("result", "Ürün Ekleme Başarısız");
                return mv;
            }
        }
        return mv;

    }
    @RequestMapping("/error")
    public ModelAndView errorPage(){
        return new ModelAndView("error");
    }

}
