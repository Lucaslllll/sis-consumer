/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.database;

import com.mycompany.sis.consumer.entity.Entity;
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
    public void save(Entity entity) {
        this.entityTables.put(id, (T) entity);
        this.id += 1;
    }

    @Override
    public Optional findById(int id) {
        T found = this.entityTables.get(id);
        return Optional.ofNullable(found);
    }

    @Override
    public List findAll() {
        List<T> getAll = new ArrayList<>(Arrays.asList(this.entityTables));
    }

    @Override
    public void update(int id, Entity entity) {
    
    }

    @Override
    public void delete(int id) {
    
    }
    
}
