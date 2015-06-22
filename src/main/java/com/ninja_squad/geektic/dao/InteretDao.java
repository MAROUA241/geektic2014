package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import com.ninja_squad.geektic.model.Interet;

public class InteretDao {
	@PersistenceContext
	private EntityManager em;

	 public List<Interet> getAllInteret()
	 {
         String jpql = "Select int from Interet as int";
         TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);
         return query.getResultList(); 
	 }
	 
	 public Interet getInteretById(int id)
	 {
         return em.find(Interet.class, id); 
	 }
}
