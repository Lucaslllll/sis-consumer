/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.dao.GeralDAO;
import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.GetProductsByTableService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class RemoveProductsInTableView implements View{

    @Override
    public void startView() {
        
    }
    
    public void start(Table table) throws DAOException, DatabaseException{
        try {
            Scanner sc = new Scanner(System.in);
            short opcao;
            Loop:while(true){
            
                // pego os produtos de uma mesa passando ela como filtro
                GetProductsByTableService ges = new GetProductsByTableService();

                print("\nEssa é a lista dos produtos pedidos na mesa: \n");
                int count = 1;
                for(Request req  : ges.filterByTable(table)){
                    print("\n Digite '"+count+"' para remover o pedido '"+req.getProduct().getName()+"' da mesa \n");
                    count++;
                }
                
                print("\nPara sair digite -1 \n");
                opcao = sc.nextShort();
                if(opcao == -1){
                    break Loop;
                }
                
                
                GeralDAO dao = new GeralDAO();
                dao.delete(Request.class, ges.filterByTable(table).get(opcao-1));
                
                print("Removido com sucesso! \n\n");
                
            
            }
            
        } catch (DAOException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }
    
}
