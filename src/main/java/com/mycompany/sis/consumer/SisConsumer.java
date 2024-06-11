/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sis.consumer;

import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.database.DatabaseTable;
import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.view.MainView;


/**
 *
 * @author Lucas
 */
public class SisConsumer {

    public static void main(String[] args) {
        MainView mainview = new MainView();
        mainview.startView();
        
        Category c = new Category("Bebidas");
        DatabaseTable db = new DatabaseTable();
        db.save(c);
        
        System.out.println(db.findAll());
        
        db.delete(1);
        
        System.out.println(db.findAll());
        
        db.save(c);
        System.out.println(db.findAll());
        
        Category c2 = new Category("Suco");
        db.update(2, c2);
        System.out.println(db.findAll());
    }
}
