/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.CheckExpedientService;
import com.mycompany.sis.consumer.service.LoginService;
import com.mycompany.sis.consumer.service.OpenExpedientService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class LoginView implements View{

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        print("Para abrir o sistema coloque seu email e senha abaixo: \n\n");
        print("Email: \n");
        String email = sc.nextLine();
        print("Senha: \n");
        String password = sc.nextLine();
        
        
        // falta implementar
        LoginService ls = new LoginService();
        try {
            if(ls.do_login(email, password)){
                MainView.logadoAdmin = ls.isAdmin(email);
                
                // check se há expedient aberto
                CheckExpedientService ces = new CheckExpedientService();
                
                if(ces.test()){
                    
                    // Vai para tela de abrir expediente
                    ExpedientView ev = new ExpedientView();
                    ev.startView();
                }
                
                
                
                
                
                
            }else{
                print("\nretornando a tela principal \n");
            }
            
            

//        sc.close();
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(LoginView.class.getName());
        } catch (DAOException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
