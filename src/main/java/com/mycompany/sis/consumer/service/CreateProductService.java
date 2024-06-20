/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

/**
 *
 * @author Lucas
 */
public class CreateProductService {
    public void make(Product p) throws DAOException, MigrationNotMakeException{
        GeralDAO dao = new GeralDAO();
        dao.save(Product.class, p);
        
        System.out.println("Produto "+p.getName()+" criado com sucesso! ");
    }
}
