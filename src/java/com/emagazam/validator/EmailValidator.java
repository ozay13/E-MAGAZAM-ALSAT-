/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.validator;

import com.emagazam.model.Products;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author ozaytunctan13
 */
@Component
public class EmailValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Products.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//		User user = (User)target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "","Email is empty");
//		if (!user.getEmail().contains("@")) {
//			errors.rejectValue("email","", "Email is not valid.");
//		}
    }
}
