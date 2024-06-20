/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.List;

import java.util.function.Predicate;

/**
 *
 * @author Lucas
 */
public class ListAllTablesService {
    public List<Table> list() throws DAOException, MigrationNotMakeException{
        GeralDAO dao = new GeralDAO();
        
        // Predicate<Table> tableFilter  = table -> table.getName().equals("");
        return dao.findAll(Table.class);        
        
    }
}
