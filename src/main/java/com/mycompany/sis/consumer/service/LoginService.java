/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.service;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.entity.User;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Lucas
 * Serviço responsável por realizar o login dos usuários
 */
public class LoginService {
    public boolean do_login(String email, String password) throws MigrationNotMakeException, DAOException{
        // not implemented
        GeralDAO dao = new GeralDAO();
        
        
        Predicate<User> pegarEmail = user -> user.getEmail().equals(email);
        
        // pegar o usuário pelo email
        List<User> lue = dao.findAll(User.class, pegarEmail);
        
        
        if(lue.isEmpty()){
            System.out.println("\nEmail não encontrado! ");
            return false;
            
        }else{
//            Predicate<User> pegarPassword = user -> user.getPassword().equals(password);
//            List<User> lup = dao.findAll(User.class, pegarPassword);
        
            // pego o meu usuário pelo email que está na primeira posição
            // e comparo com o parâmetro 'password'
            if(lue.get(0).getPassword().equals(password)){
                System.out.println("\nLogin feito com sucesso! ");
                return true;
            }
            
            System.out.println("\nSenha não encontrada! ");
            return false;

            
        }
        
        
        
    }
}
