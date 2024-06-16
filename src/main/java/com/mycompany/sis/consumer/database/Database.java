/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.database;

import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.EntityNotFoundException;
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
public class Database<T extends Entity> {
    private static Database instance;
    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();
    
    public void migrate(Class<? extends Entity> c, DatabaseTableI<? extends Entity> dbt){
        tables.put(c, dbt);
        
    }
    
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        
        return instance;
    }
    
    
    public void save(Class<T> clazz, T entity) throws DatabaseException{
        tables.get(clazz).save(entity);
        
    };
    
    public Optional<T> findById(int id) throws DatabaseException, EntityNotFoundException{
        
        List<T> list;
        
        list = new ArrayList<T>(
                (Collection<? extends T>) this.tables.get(Entity.class).findAll()
        );
        
        return Optional.ofNullable(list.get(id));
    };
    
    public List<T> findAll() throws DatabaseException{
        List<T> list;
        list = new ArrayList<T>(
                (Collection<? extends T>) this.tables.get(Entity.class).findAll()
        );
        
        return list;
    };
    
    public void update(int id, T entity) throws DatabaseException{
        tables.get(Entity.class).update(id, entity);
    };
    
    public void delete(int id) throws DatabaseException{
        tables.get(Entity.class).delete(id);
    };
    
}
