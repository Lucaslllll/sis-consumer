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
public class CategoryAdminView implements View {

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        
        print("Deseja quais das opções: \n\n");
        print("1- Cadastrar categoria no sistema \n");
        print("2- Listar categoria no sistema \n"); 
        print("3- Retirar categoria do sistema \n");
        print("outro valor- Voltar \n\n");
        
        short opcao = sc.nextShort();
    }
    
}
