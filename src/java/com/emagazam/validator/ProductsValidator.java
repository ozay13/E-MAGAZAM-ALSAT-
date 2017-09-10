/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.validator;

import com.emagazam.model.Products;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author ozaytunctan13
 */
@Component
public class ProductsValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Products.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Products product = (Products) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "required.productName");

        if ("NONE".equals(product.getProductName())) {
            errors.rejectValue("productName", "required.productName");
        }
     
    }

}
