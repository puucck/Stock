package com.point;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
public class Product {
    String name;
    int id;
    BigDecimal price;
    int number;
    Date product_Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getProduct_Date() {
        return product_Date;
    }

    public void setProduct_Date(Date product_Date) {
        this.product_Date = product_Date;
    }

    public Date getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(Date shelf_life) {
        this.shelf_life = shelf_life;
    }

    Date shelf_life;
}
