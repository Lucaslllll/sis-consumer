/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.RegisterCategoryProductService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        try {
            RegisterCategoryProductService rcp = new RegisterCategoryProductService(category);
        } catch (DatabaseException ex) {
            Logger.getLogger(RegisterCategoryProductView.class.getName());
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(RegisterCategoryProductView.class.getName());
        } catch (DAOException ex) {
            Logger.getLogger(RegisterCategoryProductView.class.getName());
        }
        
    }
}
