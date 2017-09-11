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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ozaytunctan13
 */
@Entity
@Table(name = "products")
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @NotEmpty(message = "Lütfen ürün adı alanını boş gecmeyiniz!.")
    @Size(max = 45, message = "Lütfen Karakter aralığını aşmayınız(1-45)")
    @Column(name = "product_name", length = 45, nullable = false)
    private String productName;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "creation_date")
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Products(Long id, String productName, Long categoryId, Long brandId, Date creationDate, Date modifiedDate) {
        this.id = id;
        this.productName = productName;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
    }

    public Products(String productName, Long categoryId,Long brandId,Date creationDate, Date modifiedDate) {
         this(0L, productName, categoryId, brandId, creationDate, modifiedDate);
    }

    public Products() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

  
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
