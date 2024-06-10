/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Category;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class RegisterCategoryProductView implements View{
    

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        print("Digite o nome de uma categoria para os alguns dos seus produtos: ");
        String name = sc.nextLine();
        Category category = new Category(name);
        
    }
}
