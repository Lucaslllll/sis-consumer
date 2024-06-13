/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.dao;

import com.mycompany.sis.consumer.database.DatabaseTableI;
import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.exception.DatabaseException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lucas
 */
public class CategoryDAO <T extends Entity>{
   
    
    void save(Class<T> clazz, T entity) throws DatabaseException{
        
    };
    
    Optional<T> findById(int id) throws DatabaseException{
        T a = null;
        
        return Optional.ofNullable(a);
    };
    
    List<T> findAll() throws DatabaseException{
        List<T> list = null;
        
        return list;
    };
    
    void update(int id, T entity) throws DatabaseException{
    
    };
    
    void delete(int id) throws DatabaseException{
    
    };
}
