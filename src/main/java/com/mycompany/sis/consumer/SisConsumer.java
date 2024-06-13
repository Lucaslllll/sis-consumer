/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sis.consumer;

import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.database.DatabaseTable;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.view.MainView;


/**
 *
 * @author Lucas
 */
public class SisConsumer {

    public static void main(String[] args) throws DatabaseException {
        MainView mainview = new MainView();
        mainview.startView();
        
        
    }
}
