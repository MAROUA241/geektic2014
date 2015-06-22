package com.ninja_squad.geektic.dao;

import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Geek;

@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Geek> getAllGeek(char sexe) {
		String jpql = "SELECT geek FROM Geek as geek WHERE geek.sexe=:sexe";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("sexe", String.valueOf(sexe));
		return query.getResultList();
	}

	public Geek getGeekById(int id) {
		return em.find(Geek.class, id);
	}

}
