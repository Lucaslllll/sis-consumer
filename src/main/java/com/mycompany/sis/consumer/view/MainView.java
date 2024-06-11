/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import java.util.Scanner;

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
            print("O sistema está aberto/fechado (falta implementar): \n");
            print("Deseja quais das opções: \n\n");
            print("1- Abrir sistema \n");
            print("2- Consultar produtos \n");
            print("3- Editar produtos (admin) \n");
            print("4- Sair \n");

            opcao = sc.nextShort();

            switch(opcao){
                case 1:
                    print("");
                break;
                case 2:
                    print("");
                break;
                case 3:
                    print("");
                break;
                case 4:
                    break Loop;
                default:
                    continue;
                
            }
        
        }
        
        sc.close();
    }
    
}
