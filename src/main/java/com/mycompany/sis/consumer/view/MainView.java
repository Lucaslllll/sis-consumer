/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

/**
 *
 * @author Lucas
 */
public class MainView implements View{
    public void print(String s){
        System.out.print(s);
    }
    

    @Override
    public void startView() {
        print("\n");print("\n");print("\n");
        print("---------------- Bem-vindo ao SIS Consumer ----------------");
        print("\n");print("\n");print("\n");
    }
    
}
