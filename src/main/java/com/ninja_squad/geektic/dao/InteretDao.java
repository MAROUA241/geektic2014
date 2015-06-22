package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Interet;

@Repository
public class InteretDao {
	
	@PersistenceContext
	private EntityManager em;

	 public List<Interet> getAllInteret()
	 {
         String jpql = "Select i from Interet as i";
         TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);
         return query.getResultList(); 
	 }
	 
	 public Interet getInteretById(int id)
	 {
         return em.find(Interet.class, id); 
	 }

}
