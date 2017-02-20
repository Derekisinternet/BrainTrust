package com.DerekCo.eeg.dao;

import com.DerekCo.eeg.EEGReading;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Mastermind on 2/18/17.
 */
public class EEGReadingDao extends JPADao {

    public EEGReadingDao() {
        super("manager1");
    }

    public EEGReadingDao(EntityManagerFactory fact) {
        super(fact);
    }

    public void persist(EEGReading reading, int sessionId){
        reading.setSessionId(sessionId);
        persist(reading);
    }

    public EEGReading findById(long id) {
        EEGReading reading = null;
        try {
            openTransaction();
            reading = entityManager.find(EEGReading.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return reading;
    }


}
