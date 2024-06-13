/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.service.LoginService;
import com.mycompany.sis.consumer.service.OpenExpedientService;
import java.util.Scanner;

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
        if(ls.do_login(email, password)){
            // abre novo expediente
            OpenExpedientService oes = new OpenExpedientService();
            
            // Vai para tela de expediente
            ExpedientView ev = new ExpedientView();
        
        }else{
            print("Email ou Senha incorretos... retornando a tela principal");
        }
        
        
        
//        sc.close();
    }
    
}
