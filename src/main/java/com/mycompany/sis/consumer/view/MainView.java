/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.CheckExpedientService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class MainView implements View{
    
    

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        short opcao;
        
        print("\n");print("\n");print("\n");
        print("---------------- Bem-vindo ao SIS Consumer ----------------");
        print("\n");print("\n");print("\n");
        
        
        Loop: while(true){   
            
            CheckExpedientService ces = new CheckExpedientService();
            try {
                if(ces.test()){
                    print("\nO sistema está fechado: \n");
                    print("1- Abrir sistema \n");
                    print("2- Sair \n");
                    opcao = sc.nextShort();

                    switch(opcao){
                        case 1:
                            LoginView lv = new LoginView();
                            lv.startView();
                        break;
                        case 2:
                            break Loop;
                        default:
                            continue;

                    }
                    
                }else{
                    print("Deseja quais das opções: \n\n");
                    print("1- Abrir mesa \n");
                    print("2- Selecionar um mesa aberta \n");
                    print("3- Verificar stock dos produtos cadastrados \n");
                    print("4- Fechar mesar \n");
                    print("5- Fechar expediente \n");
                    print("6- Editar produtos (admin) \n"); 
                    print("7- Editar categorias de produtos \n");
                    print("8- Editar mesas \n");
                    
                    opcao = sc.nextShort();

                    switch(opcao){
                        case 1:
                            OpenTablesView otv = new OpenTablesView();
                            otv.startView();
                        break;
                        case 2:
                            print("");
                        break;
                        case 3:
                            print("");
                        break;
                        
                        default:
                            continue;
                    }
                
                }
                
            } catch (MigrationNotMakeException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DAOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            

            
        
        }
        
        sc.close();
    }
    
}
