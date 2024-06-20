/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class GetExpedientService {
    public Expedient get() throws DAOException, MigrationNotMakeException{
        GeralDAO dao = new GeralDAO();
        List<Expedient> le = dao.findAll(Expedient.class);
        
        // retorno o último elemento da minha lista, ou seja,
        // pego o expedient aberto
        return le.get(le.size()-1); 
        
    }
}
