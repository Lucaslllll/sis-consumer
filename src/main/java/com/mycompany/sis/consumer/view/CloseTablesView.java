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
import com.mycompany.sis.consumer.service.ChangeStatusRequestService;
import com.mycompany.sis.consumer.service.ListAllTablesService;
import com.mycompany.sis.consumer.service.ChangeStatusTableService;
import com.mycompany.sis.consumer.service.GetProductsByTableService;
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
        // listar mesas abertas
        // deixar abrir somente as que estão abertas
        // ao fechar uma mesa, eu devo mostrar o valor da conta junto com o desconto
        // setar os pedidos como pagos/payed
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
                Table toClose = lats.list().get(opcao-1); // menos 1 de incremento final do for
                
                
                
                
                // imprimir a lista de pedidos da mesa e retorna o valor aplicado com desconto
                GetProductsByTableService ges = new GetProductsByTableService();
                print("\nEssa é a lista dos produtos pedidos na mesa: \n");
                count = 1;
                float montante = 0.0f;
                for(Request req  : ges.filterByTable(toClose)){
                    print("\n'"+count+"' - "+req.getProduct().getName()+" - R$ "+req.getProduct().getPrice()+" reais \n");
                    count++;
                    montante += req.getProduct().getPrice();
                }
                
                print("\n\nO valor total da mesa é R$ "+(montante-toClose.getBonus())+" reais");
                
                print("\n\nModo de pagamento: ");
                String modoPagamento = sc.nextLine();
                sc.next();
                print("\n\nConfirma fechamento? (s/n) ");
                String payed = sc.nextLine();
                
                if(payed.equals("s") || payed.equals("S")){
                    // setar true no campo payed/pago nos pedidos
                    for(Request req  : ges.filterByTable(toClose)){
                        req.setPayed(true);
                        ChangeStatusRequestService csrs = new ChangeStatusRequestService();
                        csrs.open(req);
                    }
                    
                    // fechando a mesa
                    toClose.setIsOpen(false);
                    toClose.setBonus(0.0f); 
                    // // atualizando isso no db
                    ChangeStatusTableService ots = new ChangeStatusTableService();
                    ots.open(toClose);

                    print(toClose.getName()+" foi fechada com sucesso! \n");
                    
                }
                
                print("\n");
                
            }
            
        
        } catch (DAOException | MigrationNotMakeException | DatabaseException ex) {
            Logger.getLogger(OpenTablesView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
