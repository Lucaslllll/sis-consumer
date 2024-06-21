/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.GetProductsByTableService;
import com.mycompany.sis.consumer.service.ListAllProductsService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class GetAllStockProductsView implements View {

    @Override
    public void startView() {
        // pegar todos os produtos cadastrados no sistema e vê o stock dele
        // por enquanto a função do 'stock' será só demonstrativa, já que o prazo de entrega é hoje
    
        Scanner sc = new Scanner(System.in);
        try {
            ListAllProductsService laps = new ListAllProductsService();
            int count = 1;
            
            print("\nEssa é a lista dos produtos do sistema e seus estoques: \n");
            
            
            for(Product p  : laps.list()){
                print("\n'"+count+"' - '"+p.getName()+"' que custa R$ "+p.getPrice()+" reais e tem "+p.getStock()+" de estoque \n");
                count++;
            
            }
            
            String something = sc.nextLine();
            print("\n");
            
        } catch (DAOException | MigrationNotMakeException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
