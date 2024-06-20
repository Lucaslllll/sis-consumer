/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Lucas
 */
public class GetProductsByTableService {
    // não deixar pegar mesas fechas e sim as abertas
    // pelas mesas pegar os seus produtos
    public List<Request> filterByTable(Table t) throws MigrationNotMakeException, DAOException{
        GeralDAO dao = new GeralDAO();
        
        Predicate<Request> requestFilter  = request -> request.getTable().getName().equals(t.getName());
        
        
        List<Request> le = dao.findAll(Request.class, requestFilter);
        
        return le;
    }
}
