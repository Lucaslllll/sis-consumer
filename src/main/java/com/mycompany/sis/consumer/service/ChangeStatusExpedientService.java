/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

/**
 *
 * @author Lucas
 */
public class ChangeStatusExpedientService {
    public void open(Expedient ex) throws MigrationNotMakeException, DAOException, DatabaseException{
        GeralDAO dao = new GeralDAO();
        dao.update(Expedient.class, ex);
    }
}
