package com.DerekCo.eeg.dao;

import com.DerekCo.eeg.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Mastermind on 2/18/17.
 */
public abstract class JPADao<T, K extends Serializable> {
    private static EntityManagerFactorySingleton emfSingle = EntityManagerFactorySingleton.getInstance();
    private EntityManagerFactory factory;
    private String defaultDB;

    @PersistenceContext
    protected EntityManager entityManager;

    public JPADao() {}

    public JPADao(String db){
        setDB(db);
        try {
            factory = emfSingle.getEmf(getDB());
        } catch (Exception e) {
            System.out.println("Unable to Create EntityManagerFactory for Dao.");
        }
    }

    public JPADao(EntityManagerFactory fact) {
        factory = fact;
    }

    public void openTransaction() throws Exception{
        this.entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public <E> void persist(E entity) {
        try {
            openTransaction();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        entityManager.close();
    }

    public <T,K> T findById(Class<T> entityClass, K id) {
        T entity = null;
        try {
            openTransaction();
            entity = entityManager.find(entityClass, id);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        entityManager.close();
        return entity;
    }

    // change the EntityManagerFactory that gets accessed for DB
    // transactions. Uses the entry names in persistence.xml
    public void setDB(String persistenceName) {
        this.defaultDB = persistenceName;
    }

    public String getDB() {
        return defaultDB;
    }


}
