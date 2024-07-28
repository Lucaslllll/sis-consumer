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

import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

import com.mycompany.sis.consumer.service.CreateCategoryService;
import com.mycompany.sis.consumer.service.CreateProductService;
import com.mycompany.sis.consumer.service.CreateTableService;
import com.mycompany.sis.consumer.service.CreateUserService;

import com.mycompany.sis.consumer.view.MainView;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Lucas
 */
public class SisConsumer {
    
    public static void main(String[] args) throws DatabaseException, MigrationNotMakeException, DAOException {
        
        
        List<Class> nameTableMigrate = new ArrayList(
                List.of(Category.class, Expedient.class, Table.class,
                            User.class, Product.class, Request.class
                )
        );
        
//        Database db = new Database();
        for(Class c : nameTableMigrate){
            DatabaseTable tb = new DatabaseTable(c);
//            db.migrate(c, tb);
            Database.getInstance().migrate(c, tb);
        }
        
        
        // para testar e demonstrar o sistema
        // eu irei criar as primeiras categorias, produtos e mesas
        
        // registrando previamente algumas categorias de produtos do sistema
        Category c1 = new Category("Bebidas");
        Category c2 = new Category("Petiscos");
        CreateCategoryService cs = new CreateCategoryService();
        cs.make(c1);
        cs.make(c2);
        
        // registrando previamente os usuários do sistema
        // admin
        User u1 = new User("brinfo", "admin@gmail.com", "allons-y", true);
        // waiter
        User u2 = new User("dev", "waiter@gmail.com","dev12345");
        
        CreateUserService us = new CreateUserService();
        us.make(u1);
        us.make(u2);
        
        
        // criar previamente algumas mesas
        Table t1 = new Table("T1");
        Table t2 = new Table("T2");
        Table t3 = new Table("T3");
        CreateTableService cts = new CreateTableService();
        cts.make(t1);
        cts.make(t2);
        cts.make(t3);
        
        
        // criar previamente alguns produtos
        Product p1 = new Product("Churrasco", 4.5f, c2, 50, false);
        Product p2 = new Product("Água de Coco", 3.5f, c2, 100, false);
        CreateProductService cps = new CreateProductService();
        cps.make(p1); cps.make(p2);
        
        
        
        MainView mainview = new MainView();
        mainview.startView();
        
        
        
        
    }
}
