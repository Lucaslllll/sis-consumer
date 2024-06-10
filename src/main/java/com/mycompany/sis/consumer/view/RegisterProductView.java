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
public class RegisterProductView implements View{

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        print("Digite o nome do produto: ");
        String name = sc.nextLine();
        print("Digite o preço do produto: ");
        float price = sc.nextFloat();
//    Category category;
//    int stock;
//    boolean isMissing;
//    Expedient expedient;
        
        sc.close();
    }
    
}
