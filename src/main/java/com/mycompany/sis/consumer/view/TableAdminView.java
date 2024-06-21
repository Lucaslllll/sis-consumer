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
public class TableAdminView implements View{

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        
        print("Deseja quais das opções: \n\n");
        print("1- Cadastrar mesa no sistema \n");
        print("2- Listar mesa no sistema \n"); 
        print("3- Retirar mesa do sistema \n");
        print("outro valor- Voltar \n\n");
        
        short opcao = sc.nextShort();
    }
    
}
