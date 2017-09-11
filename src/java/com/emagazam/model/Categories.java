/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emagazam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ozaytunctan13
 */
/* Kategori tablomun entity sınıfı(nesnesi,objesi)*/
@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name", length = 45, nullable = false, unique = true)
    private String categoryName;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;
    
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "brand_detail",joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="category_id"))
//    private List<Brands> brandList;
//
//    public List<Brands> getBrandList() {
//        return brandList;
//    }
//
//    public void setBrandList(List<Brands> brandList) {
//        this.brandList = brandList;
//    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
    

}
