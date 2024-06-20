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
    void save(Class clazz, T entity) throws DAOException;
    
    Optional<T> findById(Class<T> clazz, int id) throws DAOException;
    
    List<T> findAll(Class<T> clazz) throws DAOException;
    
    List<T> findAll(Class<T> clazz, Predicate<T> filter) throws DAOException;
    
    List<T> findAll(Class<T> clazz, Comparator<T> comparator) throws DAOException;
    
    void update(Class<T> clazz, int id, T entity) throws DAOException;
    
    void delete(Class<T> clazz, int id) throws DAOException;
    
}
