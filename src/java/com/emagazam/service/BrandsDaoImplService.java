/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.service;

import com.emagazam.dao.BrandsDao;
import com.emagazam.dao.BrandsDaoImpl;
import com.emagazam.model.Brands;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 *
 * @author ozaytunctan13
 */
@Service
public class BrandsDaoImplService implements BrandsDao {

    @Autowired
    BrandsDaoImpl dao;

    @Override
    @Transactional
    public boolean insertBrand(Brands c) {
        return dao.insertBrand(c);
    }

    @Transactional
    @Override
    public boolean updateBrand(Brands c) {
        return dao.updateBrand(c);
    }

    @Transactional
    @Override
    public boolean deleteBrand(Long id) {
        return dao.deleteBrand(id);
    }


    @Transactional
    @Override
    public Brands findBrandId(Long id) {
        return dao.findBrandId(id);
    }

    @Transactional
    @Override
    public List<Brands> allBrandList() {
        return dao.allBrandList();
    }

}
