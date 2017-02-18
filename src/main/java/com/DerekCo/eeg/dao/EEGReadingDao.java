package com.DerekCo.eeg.dao;

import com.DerekCo.eeg.EEGReading;
import com.DerekCo.eeg.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;

/**
 * Created by Mastermind on 2/18/17.
 */
public class EEGReadingDao {
    private  EntityManagerFactorySingleton emfSingle = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager;

    public  void persist(EEGReading reading, int sessionId){
        reading.setSessionId(sessionId);
        entityManager = emfSingle.getEmf().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(reading);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
