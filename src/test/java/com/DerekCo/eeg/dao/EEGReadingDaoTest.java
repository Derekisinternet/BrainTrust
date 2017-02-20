package com.DerekCo.eeg.dao;

import com.DerekCo.eeg.EEGReading;
import com.DerekCo.eeg.JPAHibernateTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.security.auth.login.Configuration;

/**
 * Created by Mastermind on 2/18/17.
 */
public class EEGReadingDaoTest extends JPAHibernateTest{
    String sample = "16:55:25:791,200,0,0,86919,48488,6439,25507,12768,4335,2645,3233\n";
    EEGReading row = new EEGReading(sample.trim());


    @Test
    public void testPersist() {
        EEGReadingDao dao = new EEGReadingDao(emf);
        dao.persist(row);

        assertNotNull(dao.findById(row.getReadingId()));
    }

    @Test
    public void testRetrieve() {
        row.setSessionId(123);
        em.getTransaction().begin();
        em.persist(row);
        em.getTransaction().commit();

        EEGReadingDao dao = new EEGReadingDao(emf);
        EEGReading retrieved = dao.findById(row.getReadingId());

        assertEquals(row.getHighGamma(), retrieved.getHighGamma());
    }

}
