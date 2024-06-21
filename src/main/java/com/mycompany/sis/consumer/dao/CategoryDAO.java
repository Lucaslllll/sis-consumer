/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis.consumer.dao;

import com.mycompany.sis.consumer.database.Database;
import com.mycompany.sis.consumer.database.DatabaseTableI;
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

public class CategoryDAO{
    
//public class CategoryDAO <T extends Entity> implements DAO{
//    private Database database;
//
//    public CategoryDAO() throws MigrationNotMakeException {
//        this.database = Database.getInstance();
//    }
//
//    
//    @Override
//    public void save(Class type, Entity entity) throws DAOException {
//        
//    }
//
//    @Override
//    public Optional findById(int id) throws DAOException {
//        try {
//            return database.findById(id);
//        } catch (EntityNotFoundException e) {
//            throw new DAOException(e.getMessage());
//        } catch (DatabaseException ex) {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return null;
//    }
//
//    @Override
//    public List<T> findAll() throws DAOException {
////        try {
////            return this.database.findAll();
////        } catch (DatabaseException e) {
////            throw new DAOException(e.getMessage());
////        }
//    }
//
//    @Override
//    public List<T> findAll(Predicate filter) throws DAOException {
//        Stream st = null;
////        try {
////            st = Stream.of(this.database.findAll());
////            st.filter(filter);
////        } catch (DatabaseException ex) {
////            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        
//        
//        return st.toList();
//        
//    }
//
//    @Override
//    public List findAll(Comparator comparator) throws DAOException {
//        Stream st = null;
////        try {
////            st = Stream.of(this.database.findAll());
////            st.sorted(comparator);
////        } catch (DatabaseException ex) {
////            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        
//        
//        return st.toList();
//
//    }
//
//    @Override
//    public void update(int id, Entity entity) throws DAOException {
//
//    }
//
//    @Override
//    public void delete(int id) throws DAOException {
//
//        
//    }
   
    
 
}
