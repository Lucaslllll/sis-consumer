/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
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
public class ApplyBonusView implements View{

    
    @Override
    public void startView() {
        
    }
    
    // pegar o montante de todos os produtos da mesa e retornar para o usuário
    // pedir o quanto que ele quer dar desconto
    // retornar o valor dos produtos menos o desconto
    // salvar isso na mesa campo 'bonus'
    // porém terei de lembrar de zerar esse campo ao fechar a mesa ( resolvido ;) )
    // lembrar de quando fechar ou pegar a meia, aplicar o desconto da mesa ( )
    public void start(Table table) throws DatabaseException{
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
            
            print("\n\nO valor total da mesa é R$ "+montante+" reais");
            
            
            print("\n\nQuanto você quer dar de desconto: ");
            float desconto = sc.nextFloat();
            print("\n\nEsse é o valor com o desconto aplicado: "+(montante-desconto));
            
            table.setBonus(desconto); 
                
            ChangeStatusTableService ots = new ChangeStatusTableService();
            ots.open(table);
            
            print("\n\n");
            
        } catch (DAOException | MigrationNotMakeException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
}
