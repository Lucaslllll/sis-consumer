/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sis.consumer.database;

import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.exception.DatabaseException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lucas
 */
public interface DatabaseTableI<T extends Entity> {
    void save(T entity) throws DatabaseException;
    
    Optional<T> findById(int id) throws DatabaseException;
    
    List<T> findAll() throws DatabaseException;
    
    void update(int id, T entity) throws DatabaseException;
    
    void delete(int id) throws DatabaseException;

}
