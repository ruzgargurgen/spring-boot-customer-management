package com.rgurgen.customermanagement.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity<Long>{

    private String productName;

    private Long count;

    private BigDecimal price;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId",referencedColumnName = "id")
    private Company company;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(String productName, Long count, BigDecimal price, Company company, Category category) {
        this.productName = productName;
        this.count = count;
        this.price = price;
        this.company = company;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
