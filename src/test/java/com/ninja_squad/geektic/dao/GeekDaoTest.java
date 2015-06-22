package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.model.Geek;

public class GeekDaoTest extends BaseDaoTest {
	
	@Before
	public void setup()
	{
		Geek geek = new Geek("Maroua","othman","maroua@hotmail.fr","","f");
	}
	@Autowired
	private GeekDAO GeekTest;

	@Test
	public void testGetAllGeek() {

		List<Geek> MaListe = GeekTest.getAllGeek('f');

		assertEquals(MaListe.size(), 1);

	}

    @Test
	public void testGetGeekById() {
		Geek monGeek = Mockito.mock(Geek.class);
		assertEquals(monGeek.getPrenom(), "Maroua");
	}

}
