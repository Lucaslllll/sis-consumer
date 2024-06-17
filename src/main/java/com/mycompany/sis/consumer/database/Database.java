/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.database;

import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.entity.Product;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.EntityNotFoundException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 *
 * @author Lucas
 */
public class Database {
    private static Database instance;
    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();
    
    
    public void migrate(Class<? extends Entity> c, DatabaseTableI<? extends Entity> dbt){
        this.tables.put(c, dbt);
        
        
    }
    
    public static Database getInstance() throws MigrationNotMakeException {
        if (Database.instance == null) {
              Database.instance = new Database();
//            throw new MigrationNotMakeException("Error, make a migration of database before");
        }
        
        return Database.instance;
    }
    
  
    
    public <T extends Entity> void save(Class<T> clazz, T entity) throws DatabaseException{
        // primeiro eu pego minha tabela e depois eu salvo
        DatabaseTable<T> dbt = (DatabaseTable<T>) Database.instance.tables.get(clazz);
        
        System.out.println(this.tables);
        System.out.println(dbt);
        if(dbt != null){
            dbt.save(entity);
        }
        
    };
    
    public <T extends Entity> Optional<T> findById(int id) throws DatabaseException, EntityNotFoundException{
        
        List<T> list;
        
        list = new ArrayList<T>(
                (Collection<? extends T>) Database.instance.tables.get(Entity.class).findAll()
        );
        
        return Optional.ofNullable(list.get(id));
    };
    
    public <T extends Entity> List<T> findAll() throws DatabaseException{
        List<T> fa = null; 
                
//        System.out.println(this.tables.values().stream().sorted().toList());
        
//        System.out.println(this.tables);
//        System.out.println(
//                Database.instance.tables.values().stream().toList().get(0).findAll().stream().toList()
//        );
//        Database.instance.tables.values().stream().toList().
        int contador = 0;
        for(var a : Database.instance.tables.values().stream().toList()){
            System.out.println(a.findAll());
        }
    
        return fa;
        
    };
    
    public <T extends Entity> void update(Class<T> clazz, T entity) throws EntityNotFoundException, DatabaseException{
        DatabaseTable<T> dbt = (DatabaseTable<T>) this.tables.get(clazz);
        
        if(dbt != null){
            dbt.update(entity);
        }
//        this.tables.get(clazz).update(0, entity);
    };
    
    public <T extends Entity> void delete(Class<T> clazz, int id) throws DatabaseException{
        this.tables.get(clazz).delete(id);
    };
    
}
