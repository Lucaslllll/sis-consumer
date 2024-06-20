/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.view;

import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import com.mycompany.sis.consumer.service.OpenExpedientService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ExpedientView implements View {

    @Override
    public void startView() {
        // abre novo expediente
        OpenExpedientService oes = new OpenExpedientService();
        Scanner sc = new Scanner(System.in);
        
        print("\nPara abrir um expediente, será necessário que você coloque as seguintes informações: \n");
        print("\nDigite a data de hoje (no formato dd-mm-aa): ");
        String dateOpen = sc.nextLine();
        try {
            oes.open(dateOpen, true);
        } catch (MigrationNotMakeException ex) {
            Logger.getLogger(ExpedientView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(ExpedientView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        print("\nAberto com sucesso! \n\n");
    }
    
}
