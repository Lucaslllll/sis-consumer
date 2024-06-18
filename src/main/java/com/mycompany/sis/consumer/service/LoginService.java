/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.entity.User;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

/**
 *
 * @author Lucas
 * Serviço responsável por realizar o login dos usuários
 */
public class LoginService {
    public boolean do_login(String email, String password) throws MigrationNotMakeException{
        // not implemented
        GeralDAO dao = new GeralDAO();
        
        
        
        return true;
    }
}
