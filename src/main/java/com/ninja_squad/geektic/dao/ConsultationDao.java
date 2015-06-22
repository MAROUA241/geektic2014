package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import com.ninja_squad.geektic.model.Consultation;

public class ConsultationDao {
	
	@PersistenceContext
	private EntityManager em;
	
	 public List<Consultation> getAllConsultation()
	 {
         String jpql = "SELECT c FROM Consultation as c ";
         TypedQuery<Consultation> query = em.createQuery(jpql, Consultation.class);
         return query.getResultList(); 
	 }
	 
	 public void insertConsultation(int idGeek, String  adresseIp) 
	 {

		 java.util.Date date = new java.util.Date(); 
		 
		 Consultation maCons = new Consultation(adresseIp,idGeek,date);

		 em.persist(maCons);
		 
	 }
}

