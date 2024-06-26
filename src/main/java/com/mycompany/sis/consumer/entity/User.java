/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.entity;

/**
 *
 * @author Lucas
 */
public class User extends Entity{
    private String name;
    private String email = "";
    private String password;
    private boolean isAdmin = false;
    
    
    public User(String name, String email, String password, boolean isAdmin){
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        
    }
    
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
