/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.database.DatabaseTable;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.exception.DatabaseException;

/**
 *
 * @author Lucas
 */
public class RegisterCategoryProductService {
      
    public RegisterCategoryProductService(Category c) throws DatabaseException{
        DatabaseTable db = new DatabaseTable();
        db.save(c);
        
        System.out.println("Registrado Um Nova Categoria Com Sucesso! ");
    }

}
