package com.DerekCo.eeg;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * Created by Mastermind on 2/18/17.
 */
public class EntityManagerFactorySingleton {
    private static final EntityManagerFactorySingleton singleton = new EntityManagerFactorySingleton();
    private EntityManagerFactory emf;

    // empty constructor so external users can't instantiate.
    private EntityManagerFactorySingleton(){
    }

    //returns the singleton object
    public static EntityManagerFactorySingleton getInstance() {
        return singleton;
    }

    // returns the EntityManagerFactory object:
    public EntityManagerFactory getEmf(){
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("manager1");
            }
            catch (PersistenceException exception) {
                System.out.println("Error creating EntityManagerFactory: ");
                exception.printStackTrace();
            }
        }
        return emf;
    }

    public void closeEmf() {
        if (emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
    }
}
