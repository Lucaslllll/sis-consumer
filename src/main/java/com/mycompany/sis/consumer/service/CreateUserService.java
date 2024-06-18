/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;


import com.mycompany.sis.consumer.dao.GeralDAO;

import com.mycompany.sis.consumer.database.Database;

import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.entity.User;
import com.mycompany.sis.consumer.exception.DAOException;

import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author Lucas
 */
public class CreateUserService {
  
    public void make(User u) throws MigrationNotMakeException, DAOException{
        
        
        GeralDAO dao = new GeralDAO();
        dao.save(User.class, u);
        
        if(u.isIsAdmin()){
            System.out.println("Novo Admin Registrado! ");
        }else{
            System.out.println("Novo Usuário Registrado! ");
        }
        
        
    }
}
