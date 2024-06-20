/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.FilterOpenTableService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class TableView implements View{

    @Override
    public void startView() {
        Scanner sc = new Scanner(System.in);
        FilterOpenTableService fots = new FilterOpenTableService();
        short opcao;
        
        
        try {
            if(!fots.list().isEmpty()){
                int count = 1;
                for(Table t : fots.list()){
                    print("Digite '"+count+"' para selecionar a mesa '"+t.getName()+"' \n");
                    count++;

                }

                opcao = sc.nextShort();
                Table table = fots.list().get(opcao-1);

                print("Deseja quais das opções: \n\n");
                print("1- Adicionar produto na mesa \n");    // lista e pega 
                print("2- Listar produtos de uma mesa \n"); // selecionar mesa e pegar
                print("3- Retirar produto da mesa \n");
                print("4- Aplicar desconto \n");
                print("5- Ver valor atual da mesa (meia) \n");
                print("6- Voltar \n\n");

                opcao = sc.nextShort();

                switch(opcao){
                    case 1:
                        PutProductsInTableView ppitv = new PutProductsInTableView();
                        ppitv.start(table);
                    break;
                    case 2:
                        ListProductsInTableView lpit = new ListProductsInTableView();
                        lpit.start(table);
                    break;
                    case 3:
                        RemoveProductsInTableView rpitv = new RemoveProductsInTableView();
                    break;
                    case 4:
                    break;
                    case 5:
                    break;
                    case 6:
                    break;
                }
            }else{
                print("\nSem mesas abertas ou registradas! \n");
            }
            
        } catch (DAOException ex) {
            Logger.getLogger(TableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(TableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatabaseException ex) {
            Logger.getLogger(TableView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
