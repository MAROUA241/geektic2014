package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Enum.Sexe;

import com.ninja_squad.geektic.model.Geek;

@RestController
@Transactional
@RequestMapping("/Geeks")
public class GeekDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Geek> getAllGeeks() {
		String jpql = "SELECT geek FROM Geek as geek ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.getResultList();
	}

	public List<Geek> getGeekBySexe(Sexe sexe) {
		String jpql = "SELECT geek FROM Geek as geek WHERE geek.sexe=:sexe";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		return query.getResultList();
	}
	
	public List<Geek> findBySexeAndInteret(Sexe sexe, String interet){
		String jpql = "select distinct g from Geek g left join fetch g.interets i inner join g.interets ir where g.sexe = :sexe and ir.nom = :interet";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		query.setParameter("interet", interet);
		List<Geek> list = query.getResultList();
		return list;
	}

	public Geek getGeekById(int id) {
		return em.find(Geek.class, id);
	}



}
