package com.DerekCo.eeg;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.HashMap;

/**
 * Created by Mastermind on 2/18/17.
 */
public class EntityManagerFactorySingleton {
    private static final EntityManagerFactorySingleton singleton = new EntityManagerFactorySingleton();
    private HashMap<String, EntityManagerFactory> ledger;

    // empty constructor so external users can't instantiate.
    private EntityManagerFactorySingleton(){
    }

    //returns the singleton object
    public static EntityManagerFactorySingleton getInstance() {
        return singleton;
    }

    // returns the EntityManagerFactory object from ledger. Builds if null:
    public EntityManagerFactory getEmf(String key) throws Exception{
        if (key == null) {
            throw new IllegalArgumentException("Parameter value cannot be null");
        }
        if (this.ledger.get(key) == null) {
            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(key);
                ledger.put(key, emf);
            }
            catch (PersistenceException exception) {
                System.out.println("Error creating EntityManagerFactory: ");
                exception.printStackTrace();
            }
        }
        return ledger.get(key);
    }

    public void close() {
        for (EntityManagerFactory emf : ledger.values()) {
            if (emf.isOpen()) {
                emf.close();
            }
            emf = null;
        }
    }
}
