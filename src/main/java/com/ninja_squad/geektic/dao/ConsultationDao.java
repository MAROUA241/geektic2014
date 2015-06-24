package com.ninja_squad.geektic.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Consultation;
import com.ninja_squad.geektic.model.Geek;

@Repository
public class ConsultationDao {
	
	@PersistenceContext
	private EntityManager em;

	
	public List<Consultation> findAllGeekHistoryById(int id){
		String jpql = "SELECT c "
				+ "FROM Consultation c "
				+ "JOIN c.geek g "
				+ "WHERE g.id = :id ";
		TypedQuery<Consultation> query = em.createQuery(jpql, Consultation.class); 
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public void addHistoryById(Geek geek,String ip){
		Consultation consultation = new Consultation();
		Date date = new Date();
		consultation.setDate(date);
		consultation.setGeek(geek);
		consultation.setIp(ip);
		em.persist(consultation);
	}
	
	public int findCountGeekHistoryById(int id){
		List<Consultation> list = findAllGeekHistoryById(id);
		return list.size();
	}
	

	
}

