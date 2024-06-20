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
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.ChangeStatusExpedientService;
import com.mycompany.sis.consumer.service.GetExpedientService;
import com.mycompany.sis.consumer.service.ListAllProductsService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class PutProductsInTableView implements View {

    @Override
    public void startView() {
        
    }
    
    public void start(Table tb) throws DatabaseException{
        Scanner sc = new Scanner(System.in);
        ListAllProductsService laps = new ListAllProductsService();
        short opcao;
        try {
            Loop: while(true){
                
                int count = 1;
                for(Product p : laps.list()){
                    print("Digite '"+count+"' para adicionar '"+p.getName()+"' à mesa  \n");
                    count++;
                }
                print("Para sair digite -1 \n");
                opcao = sc.nextShort();
                
                if(opcao == -1){
                    break Loop;
                }
                
               
                // pegar o produto escolhido
                Product po = laps.list().get(opcao-1);
                // jogo no pedido o produto e a mesa
                Request req = new Request(po, tb);
                
                // pego o expediente atual e adiciono o pedido
                // assim depois pego tanto os pedidos como os produtos 
                // desse expedient outrora
                GetExpedientService ges = new GetExpedientService();
                Expedient ex = ges.get();
                ex.addProductExpedient(req);
                
                // atualizo no banco de dados essa mudança
                ChangeStatusExpedientService cse = new ChangeStatusExpedientService();
                cse.open(ex);
                
                
                
            }
        } catch (DAOException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(PutProductsInTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
