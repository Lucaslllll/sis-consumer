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

/**
 *
 * @author Lucas
 */
public class DatabaseTable<T extends Entity> implements DatabaseTableI{
    private Map<Integer, T> entityTables;
    private static int id;
    
    
    public DatabaseTable(){
        this.entityTables = new HashMap<>();
        this.id = 1;
    
    };
    
    
    @Override
    public void save(Entity entity) throws DatabaseException{
        try {
            this.entityTables.put(id, (T) entity);
            this.id += 1;
        }catch (Exception e) {
            throw new DatabaseException("Failed to save "+entity.toString()+": " + e.getMessage());
        }
    
    }

    @Override
    public Optional findById(int id) throws DatabaseException{
        T found = this.entityTables.get(id);
        return Optional.ofNullable(found);
    
    }

    @Override
    public List findAll() throws DatabaseException {
        List<T> getAll = new ArrayList<T>(this.entityTables.values());
        
        return getAll;
    }

    @Override
    public void update(int id, Entity entity) throws DatabaseException, EntityNotFoundException{
        try{
            this.entityTables.put(id, (T) entity);
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
    
}
