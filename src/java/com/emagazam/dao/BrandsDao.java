/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.dao;

import com.emagazam.model.Brands;
import com.emagazam.model.Categories;
import java.util.List;

/**
 *
 * @author ozaytunctan13
 */
public interface BrandsDao {

    public boolean insertBrand(Brands c);

    public boolean updateBrand(Brands c);

    public boolean deleteBrand(Long id);

    public Brands findBrandId(Long id);

    public List<Brands> allBrandList();
}
