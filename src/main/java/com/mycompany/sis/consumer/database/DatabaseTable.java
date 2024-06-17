/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.database;

import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Lucas
 */
public class DatabaseTable<T extends Entity> implements DatabaseTableI<T>{
    private Map<Integer, T> entityTables;
    private static int id;
    private Class type;
    
    public DatabaseTable(Class type){
        this.entityTables = new HashMap<>();
        this.id = 1;
        this.type = type;
        
    };
    
    @Override
    public void save(T entity) throws DatabaseException{
        try {
            entity.setId(id);
            this.entityTables.put(id, entity);
            this.id += 1;
        }catch (Exception e) {
            throw new DatabaseException("Failed to save "+entity.toString()+": " + e.getMessage());
        }
    
    }

    @Override
    public Optional findById(int id) throws DatabaseException{
        T found;
        try{
            found = this.entityTables.get(id);
        }catch(Exception e){
            return Optional.ofNullable(e.getMessage());
        }
        
        return Optional.of(found);
    }

    @Override
    public List findAll() throws DatabaseException {
        List<T> getAll;
        try{
            getAll = new ArrayList<T>(this.entityTables.values().stream().collect(Collectors.toList()));
        }catch(Exception e){
            throw new DatabaseException("Failed to find entities");
        }
        
        return getAll;
    }

    @Override
    public void update(int id, T entity) throws DatabaseException, EntityNotFoundException{
        try{
            this.entityTables.put(id, entity);
        }catch (Exception e) {
            throw new DatabaseException("Failed to update "+entity.toString()+": " + e.getMessage());
        }
        
    }
    @Override
    public void update(T entity) throws DatabaseException {
        int id = entity.getId();
        try{
            this.entityTables.put(id, entity);
        }catch (Exception e) {
            throw new DatabaseException("Failed to update "+entity.toString()+": " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DatabaseException{
        try{
            this.entityTables.remove(id);
        }catch (Exception e) {
            throw new DatabaseException("Failed to remove by id " + e.getMessage());
        }
    
    }
    
    
    public Class getType(){
        return this.type;
    }

    
    
}
