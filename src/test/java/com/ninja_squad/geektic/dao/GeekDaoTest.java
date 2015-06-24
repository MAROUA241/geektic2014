package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

import Enum.Sexe;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.model.Geek;

public class GeekDaoTest extends BaseDaoTest {
	
	@Autowired
    private GeekDAO dao;
	
    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(JeuxDeTest.INSERT_REFERENCE_DATA);
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
	
//	@Before
//  public void populateDatabase() {
//      Operation operation = Operations.sequenceOf(); // TODO define your operations here.
//      DbSetup dbSetup = new DbSetup(destination, operation);
//      dbSetup.launch();
//  }

	@Test
	public void testGetGeekBySexe() {
		
		List<Geek> maListe = dao.getGeekBySexe(Sexe.m);
		assertEquals(maListe.size(), 2);
	}
    @Test
	public void testGetGeekById() {
		Geek monGeek=dao.getGeekById(22);
		assertEquals(monGeek.getPrenom(), "Alex");
	}
    @Test
    public void testGetAllGeek() {
    	List<Geek> maListe = dao.getAllGeeks();
		assertEquals(maListe.size(),4);
	}
    @Test
    public void testGetGeekBySexeAndInteret(){
    	List<Geek> maListe = dao.findBySexeAndInteret(Sexe.m, "JAVA");
		assertEquals(maListe.size(),1);
	}
}
