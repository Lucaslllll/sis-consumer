/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.User;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Lucas
 * Esse serviço deverá retornar se há algum expedient aberto
 */
public class CheckExpedientService {
    public boolean test() throws MigrationNotMakeException, DAOException{
        
        GeralDAO dao = new GeralDAO();        
        
        
        Predicate<Expedient> checkOpened = expedient -> expedient.isIsOpen() == true;
        
        List<Expedient> le = dao.findAll(Expedient.class, checkOpened);
        
        // System.out.println("lista de expedientes "+le);
        // corrigir, passar um filtro para saber se existe algum expedient aberto e não se tá vazio
        // se tiver vazio, então posso abrir um expediente
        if(le.isEmpty()){
            return true;
        }
        
        return false;
        
    }
}
