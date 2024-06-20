/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.ChangeStatusExpedientService;
import com.mycompany.sis.consumer.service.GetExpedientService;
import com.mycompany.sis.consumer.service.GetProductsByTableService;
import com.mycompany.sis.consumer.service.ListAllTablesService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ListProductsInTableView implements View{

    @Override
    public void startView() {
        
    }

    public void start(Table table) {
        
        try {
            // pego os produtos de uma mesa passando ela como filtro
            GetProductsByTableService ges = new GetProductsByTableService();

            print("\nEssa é a lista dos produtos pedidos na mesa: \n");
            int count = 1;
            for(Request req  : ges.filterByTable(table)){
                print("\n'"+count+"' - "+req.getProduct().getName()+" \n");
                count++;
            }

                
                
                print("\n");
            
        } catch (DAOException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
