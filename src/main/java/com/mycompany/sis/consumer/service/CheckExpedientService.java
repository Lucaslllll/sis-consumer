/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class CheckExpedientService {
    public void test() throws MigrationNotMakeException, DAOException{
        
        GeralDAO dao = new GeralDAO();        
        List<Expedient> l = dao.findAll(Expedient.class);
        
        System.out.println(l);
        
        
    }
}
