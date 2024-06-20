/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

/**
 *
 * @author Lucas
 */
public class CreateCategoryService {
    public void make(Category c) throws MigrationNotMakeException, DAOException{
        
        
        GeralDAO dao = new GeralDAO();
        dao.save(Category.class, c);
        
        System.out.println("Categoria "+c.getName()+" criada com sucesso! ");
        
        
    }
}
