/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.entity;

/**
 *
 * @author Lucas
 */
public class Expedient extends Entity{
    private String dateOpen;
    private String dateClose;
    private boolean isOpen;
    
    public Expedient(String dateOpen, String dateClose, boolean isOpen){
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
        this.isOpen = isOpen;
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
