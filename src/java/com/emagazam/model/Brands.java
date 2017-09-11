/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name = "brand_id")
    private Long id;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "creation_date")
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    public Brands(Long id, String brandName, Date creationDate, Date modifiedDate) {
        this.id = id;
        this.brandName = brandName;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
    }

    public Brands(String brandName, Date creationDate, Date modifiedDate) {

        this.brandName = brandName;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
    }

    public Brands() {
        super();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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
