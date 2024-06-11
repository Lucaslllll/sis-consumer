/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.entity;

/**
 *
 * @author Lucas
 */
public class Product extends Entity {
    private String name;
    private float price;
    private Category category;
    private int stock;
    private boolean isMissing;
    private Expedient expedient;
    
    
    public Product(String name, float price, Category category, int stock, boolean isMissing, Expedient expedient){
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.isMissing = isMissing;
        this.expedient = expedient;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isIsMissing() {
        return isMissing;
    }

    public void setIsMissing(boolean isMissing) {
        this.isMissing = isMissing;
    }
    
    
    @Override
    public String toString(){
        return this.name;
    }
}
