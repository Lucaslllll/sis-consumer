/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.database;

import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.exception.DatabaseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Lucas
 */
public class Database<T extends Entity> {
    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();
    
    public void migrate(Class<? extends Entity> c, DatabaseTableI<? extends Entity> dbt){
        tables.put(c, dbt);
    }
    
    public void save(Class<T> clazz, T entity) throws DatabaseException{
        tables.get(clazz).save(entity);
        
    };
    
    public Optional<T> findById(int id) throws DatabaseException{
        T a = null;
        
        return Optional.ofNullable(a);
    };
    
    public List<T> findAll() throws DatabaseException{
        List<T> list = null;
        
        return list;
    };
    
    public void update(int id, T entity) throws DatabaseException{
    
    };
    
    public void delete(int id) throws DatabaseException{
    
    };
    
}
