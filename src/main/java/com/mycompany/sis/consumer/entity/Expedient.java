/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.entity;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class Expedient extends Entity{
    private String dateOpen;
    private String dateClose;
    private boolean isOpen;
    private List<Product> listProducts;
    
    public Expedient(String dateOpen, boolean isOpen){
        this.dateOpen = dateOpen;
        this.isOpen = isOpen;
        this.dateClose = null;
    }
    
    // sempre quando for registrado o pedidos de uma mesa, devo adicionar ao expedient aberto
    private void addProductExpedient(Product p){
        listProducts.add(p);
    }
    
    
    
    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getDateClose() {
        return dateClose;
    }

    public void setDateClose(String dateClose) {
        this.dateClose = dateClose;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    @Override
    public String toString(){
        return this.dateOpen+" até "+this.dateClose;
    }
}
