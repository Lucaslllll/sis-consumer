/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sis.consumer;

import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.database.DatabaseTable;

import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.entity.Expedient;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.entity.Request;
import com.mycompany.sis.consumer.entity.Table;
import com.mycompany.sis.consumer.entity.User;

import com.mycompany.sis.consumer.exception.DatabaseException;

import com.mycompany.sis.consumer.view.MainView;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lucas
 */
public class SisConsumer {

    public static void main(String[] args) throws DatabaseException {
        List<Class> nameTableMigrate = new ArrayList(
                List.of(Category.class, Expedient.class, Table.class,
                            User.class, Product.class, Request.class
                )
        );
        
        Database db = new Database();
        for(Class c : nameTableMigrate){
            DatabaseTable tb = new DatabaseTable(c);
            db.migrate(c, tb);
        }
        
        
        MainView mainview = new MainView();
        mainview.startView();
        
        
        
        
    }
}
