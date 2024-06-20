/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.dao;

import com.mycompany.sis.consumer.database.Database;

import com.mycompany.sis.consumer.entity.Category;
import com.mycompany.sis.consumer.entity.Entity;

import com.mycompany.sis.consumer.exception.DAOException;
import com.mycompany.sis.consumer.exception.DatabaseException;
import com.mycompany.sis.consumer.exception.EntityNotFoundException;
import com.mycompany.sis.consumer.exception.MigrationNotMakeException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import java.util.stream.Stream;

/**
 *
 * @author Lucas
 */
public class GeralDAO<T extends Entity> implements DAO<T> {
    private Database database;

    public GeralDAO() throws MigrationNotMakeException {
        this.database = Database.getInstance();
    }

    
    @Override
    public void save(Class type, Entity entity) throws DAOException {
        try {
            this.database.save(type, entity);
        } catch (DatabaseException ex) {
            Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Optional findById(Class clazz, int id) throws DAOException {
        Optional<T> getEntity = null;
        try {
            getEntity = database.findById(clazz, id);
        } catch (DatabaseException ex) {
            Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return Optional.ofNullable(getEntity);
    }

    
    

    public void update(Class clazz, T entity) throws DAOException, DatabaseException {
        this.database.update(clazz, entity);
        
    }

    public void delete(Class clazz, T entity) throws DAOException, DatabaseException {
        this.database.delete(clazz, entity);
    }

    
    @Override
    public List findAll(Class clazz, Comparator comparator) throws DAOException {
        List<T> fList = null;
        
        try {
            fList = this.database.findAll(clazz);
            
        } catch (DatabaseException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        return fList.stream().sorted(comparator).toList();
    }

    @Override
    public List findAll(Class clazz) throws DAOException {
        try {
            return this.database.findAll(clazz);
        } catch (DatabaseException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List findAll(Class clazz, Predicate filter) throws DAOException {
        List<T> fList = null;
        
        try {
            fList = this.database.findAll(clazz);
//            System.out.println(fList.filter(filter).collect(Collectors.toList()));
//            System.out.println(fList.stream().filter(filter));
            
        } catch (DatabaseException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        return fList.stream().filter(filter).toList();
    }

    @Override
    public void update(Class<T> clazz, int id, T entity) throws DAOException {
        
    }

    @Override
    public void delete(Class<T> clazz, int id) throws DAOException {
       
    }

    
    
}
