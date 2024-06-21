/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.ChangeStatusExpedientService;
import com.mycompany.sis.consumer.service.GetExpedientService;
import com.mycompany.sis.consumer.service.ListAllTablesService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class CloseExpedientView implements View {

    @Override
    public void startView() {
        // aqui eu irei fechar o expediente
        // para isso devo verificar se não há mesas abertas
        // devo imprimir quantos pedidos foram feitos
        // o tanto que foi apurado naquele expedient 
        // e 'futuramente' o quanto de estoque foi embora (faltará implementar)
        // e 'futuramente' descontar o montante menos os descontos aplicados
        Scanner sc = new Scanner(System.in);
        ListAllTablesService lats = new ListAllTablesService();
        try {
            int count = 0;
            for(Table tb : lats.list()){
                if(tb.isIsOpen() == true){
                    count++;
                }
            }
            if(count == 0){
                GetExpedientService ges = new GetExpedientService();
                Expedient expedient = ges.get();
                
                print("\nEsses foram os pedidos realizados nesse expedient: \n\n");
                
                int count2 = 1;
                int montante = 0;
                for(Request req : expedient.getListRequest()){
                    print(""+count2+" - "+req.getProduct().getName()+" no valor de R$ "+req.getProduct().getPrice()+" \n");
                    montante += req.getProduct().getPrice();
                    count2++;
                }
                
                // haverá um problema que só poderei resolver com futura implementação
                // deverei anotar os descontos e remover do montante que mostrarei agora
                // por questões de tempo, deixa para próxima
                
                print("\nO valor obtido nesse expediente foi de R$ "+montante+" reais \n");
                
                print("\nPara fechar um expediente, será necessário que você coloque as seguintes informações: \n");
                print("\nDigite a data de hoje (no formato dd-mm-aa): \n");
                String dateOpen = sc.nextLine();
                boolean isOpen = false;
                
                expedient.setDateClose(dateOpen);
                expedient.setIsOpen(isOpen);
                
                ChangeStatusExpedientService cses = new ChangeStatusExpedientService();
                cses.open(expedient);
                
                
            }else{
                print("\nAinda existem mesas abertas! antes de fechar um expediente é necessário fechar todas \n");
            }
            
        } catch (DAOException | MigrationNotMakeException | DatabaseException ex) {
            Logger.getLogger(CloseExpedientView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
