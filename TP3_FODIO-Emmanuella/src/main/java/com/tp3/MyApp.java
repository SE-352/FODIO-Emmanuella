package com.tp3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MyApp {
	
	public static void main(String[] args) {
		
		
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("federation");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        et.commit();
        em.close();
        emf.close();
	}
}
