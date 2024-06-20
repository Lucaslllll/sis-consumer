/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.entity;

/**
 *
 * @author Lucas
 */
public class Request extends Entity{
    private Product product;
    private Table table;
    private User waiter;
    private boolean payed;
    
    public Request(Product product, Table table, User waiter){
        this.product = product;
        this.table = table;
        this.waiter = waiter;
        this.payed = false;
    }
    
    public Request(Product product, Table table){
        this.product = product;
        this.table = table;
        this.waiter = null;
        
    }
    
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }
    
    @Override
    public String toString(){
        return this.product.getName()+" da "+this.table.getName();
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
