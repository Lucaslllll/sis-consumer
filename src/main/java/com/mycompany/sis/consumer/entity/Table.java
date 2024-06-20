/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.entity;

/**
 *
 * @author Lucas
 */
public class Table extends Entity {
    private String name;
    private boolean isOpen;
    
    public Table(String name){
        this.name = name;
        this.isOpen = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    @Override
    public String toString(){
        return "A mesa '"+this.name+"' está "+String.valueOf(isOpen)+"";
    }
}
