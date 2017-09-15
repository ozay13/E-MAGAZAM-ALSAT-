/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.service;

import com.emagazam.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ozaytunctan13
 */
@Service
@Transactional
public class UsersDaoImplService implements UsersDaoService {
   
    @Autowired
    UsersDao userDao;
}
