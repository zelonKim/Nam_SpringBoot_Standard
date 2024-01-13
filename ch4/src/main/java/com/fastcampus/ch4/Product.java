package com.fastcampus.ch4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @Column(name="product_id")
    private Long id;
    private String name;

    private Long price;

    @ManyToMany(mappedBy="productList")
    List<Category> categoryList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }


    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryList=" + categoryList +
                '}';
    }


}
