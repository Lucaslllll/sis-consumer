/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

/**
 *
 * @author Lucas
 */
public class ChangeStatusTableService {
    public void open(Table t) throws MigrationNotMakeException, DAOException, DatabaseException{
        
        // pegar uma mesa e setar ela como aberta ou fechada
        GeralDAO dao = new GeralDAO();
        dao.update(Table.class, t);
        
    }
}
