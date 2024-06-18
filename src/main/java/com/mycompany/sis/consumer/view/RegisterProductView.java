/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.RegisterProductService;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        
        // escolher a categoria do produto
        print("Digite qual a categoria do seu produto? Digite uma opção abaixo: ");
        
        Category category = null;
        
        GeralDAO categories;
        try {
            categories = new GeralDAO();
            List<Category> cat = categories.findAll(Category.class);
            if(cat.isEmpty()){
                Logger.getLogger("Não há categorias registradas! \n  Para criar um produto, registre uma primeiro");
                
            }else{
                short cout = 1; 
                for(Category c : cat){
                    System.out.println(String.valueOf(cout)+" - "+c.getName());
                    cout++;
                }
                short opcao = sc.nextShort();
                
                category = cat.get(opcao);
            }
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(RegisterProductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(RegisterProductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 
        System.out.println("Digite o quanto há de estoque desse produto: ");
        int stock = sc.nextInt();
        boolean isMissing = true;
        if(stock < 1){
            isMissing = true;
        }else{
            isMissing = false;
        }
        
        Product p = new Product(name, price, category, stock, isMissing);
        
        RegisterProductService rps = new RegisterProductService(p);
        
        sc.close();
    }
    
}
