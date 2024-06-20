/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.ChangeStatusTableService;
import com.mycompany.sis.consumer.service.GetProductsByTableService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class GetPriceTableView implements View{

    @Override
    public void startView() {
        
    }
    
    public void start(Table table){
        Scanner sc = new Scanner(System.in);
        try {
            GetProductsByTableService ges = new GetProductsByTableService();

            print("\nEssa é a lista dos produtos pedidos na mesa: \n");
            int count = 1;
            float montante = 0;
            for(Request req  : ges.filterByTable(table)){
                print("\n'"+count+"' - "+req.getProduct().getName()+" - "+req.getProduct().getPrice()+" \n");
                count++;
                montante += req.getProduct().getPrice();
            }
            
            float total = montante - table.getBonus();
            print("\n\nO valor total da mesa é R$ "+total+" reais ");
            
            
            print("\n\n");
            
        } catch (DAOException | MigrationNotMakeException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
