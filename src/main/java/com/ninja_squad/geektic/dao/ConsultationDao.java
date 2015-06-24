package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.model.Consultation;

@RestController
@Transactional
@RequestMapping("/Geeks")
public class ConsultationDao {
	
	@PersistenceContext
	private EntityManager em;
	

	 public List<Consultation> findAllGeekHistoryById(int id){
			String jpql = "SELECT c "
					+ "FROM  Consultation c "
					+ "JOIN c.geek g "
					+ "WHERE g.id = :id ";
			TypedQuery<Consultation> query = em.createQuery(jpql, Consultation.class); 
			query.setParameter("id", id);
			return query.getResultList();
		}
	 
	 public void insertConsultation(int idGeek, String  adresseIp) 
	 {
		 java.util.Date date = new java.util.Date(); 
		 Consultation maCons = new Consultation(adresseIp,idGeek,date);
		 em.persist(maCons); 
	 }
	public int findCountGeekHistoryById(int id){
			List<Consultation> list = findAllGeekHistoryById(id);
			return list.size();
		}
		
	
}

