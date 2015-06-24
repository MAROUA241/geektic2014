package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.model.Interet;


@RestController
@Transactional
@RequestMapping("/interet")
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
