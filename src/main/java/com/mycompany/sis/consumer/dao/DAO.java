/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sis.consumer.dao;

import com.mycompany.sis.consumer.entity.Entity;
import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author Lucas
 */
public interface DAO <T extends Entity>{
    void save(Class type, T entity) throws DAOException;
    
    Optional<T> findById(int id) throws DAOException;
    
    List<T> findAll() throws DAOException;
    
    List<T> findAll(Predicate<T> filter) throws DAOException;
    
    List<T> findAll(Comparator<T> comparator) throws DAOException;
    
    void update(int id, T entity) throws DAOException;
    
    void delete(int id) throws DAOException;

}
