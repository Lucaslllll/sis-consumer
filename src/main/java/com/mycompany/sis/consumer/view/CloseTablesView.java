/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.ListAllTablesService;
import com.mycompany.sis.consumer.service.ChangeStatusTableService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class CloseTablesView implements View{

    @Override
    public void startView() {
        // listar mesas fechadas e abertas, todas as mesas
        // deixar abrir somente as que estão fechadas
        Scanner sc = new Scanner(System.in);        
        ListAllTablesService lats = new ListAllTablesService();
        
        
        print("\nEssas são todas as mesas cadastradas no sistema: \n");
        print("Selecione uma mesa aberta para FECHÁ-LA! \n\n");
        
        try {
            int count = 1, count2 = 1;
            for(Table t : lats.list()){
                if(t.isIsOpen() == true){
                    print("Digite '"+count+"' para fechar a mesa '"+t.getName()+"' \n");
                    count++;
                    count2++;
                }else{
                    print("A mesa '"+t.getName()+"' está fechada! \n");
                    count++;
                }
             
            }
            
            if(count2 == 1){
                print("\n ----Todas as mesas estão livres---- \n\n");
            }else{
            
                short opcao = sc.nextShort();
                Table toOpen = lats.list().get(opcao-1); // menos 1 de incremento final do for

                toOpen.setIsOpen(false);
                
                ChangeStatusTableService ots = new ChangeStatusTableService();
                ots.open(toOpen);
                
                print(toOpen.getName()+" foi fechada com sucesso! \n");
            }
            
        
        } catch (DAOException ex) {
            Logger.getLogger(OpenTablesView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(OpenTablesView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatabaseException ex) {
            Logger.getLogger(OpenTablesView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
