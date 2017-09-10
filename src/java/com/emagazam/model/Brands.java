/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ozaytunctan13
 */
/*
ORM (HIBERNATE)
Urunlerin marka bilgileri tutulduğu entity nesnesidir.


*/
@Entity
@Table(name = "brands")
public class Brands implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand_name")
    private String brandName;

    public Brands() {
        super();
    }

    public Brands(Long id, String markaName) {
        super();
        this.id = id;
        this.brandName = markaName;
    }

    public Brands(String markaName) {
        super();
        this.brandName = markaName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
