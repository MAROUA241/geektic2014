package com.ninja_squad.geektic.dao;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

import com.ninja_squad.dbsetup.operation.Operation;

public class JeuxDeTest {
	// public static final Operation DELETE_ALL = deleteAllFrom("GEEK");

	public static final Operation INSERT_REFERENCE_DATA = sequenceOf(
			insertInto("GEEK")
					.columns("Id", "prenom", "nom", "mail", "sexe", "gravatar")
					.values(1, "Maroua", "OTHMAN", "MAROUA241@gmail.com", "f",
							"/img/maroua.png")
					.values(2, "Alex", "Dupond", "alex@gmail.com", "M",
							"/img/alex.jpg")
					.values(3, "Marie", "Dupond", "marie@gmail.com", "m",
							"/img/marie.jpg")
					.values(4, "Dupond", "Pierre", "Pierre@gmail.com", "m",
							"/img/pierre.jpg").build(),
			insertInto("INTERET").columns("Id", "NOM", "DESCRIPTION")
					.values(1, "PHP", "Langage  web")
					.values(2, "JAVA", "Meilleur Langage")
					.values(3, "CSharp", "Langage").build(),
			insertInto("Geek_Interet").columns("IdGeek", "IdInteret")
					.values(1, 1).values(1, 2).values(2, 1).values(3, 2)
					.values(3, 3).values(4, 2).build(),
			insertInto("Consultation")
			.columns("id", "date","ip","geek")
					.values(1,"2014-07-03 13:12:23","127.0.0.1",1)
					.values(2,"2014-07-03 13:12:23","127.0.0.1",2)
					.values(3,"2014-07-03 13:12:23","127.0.0.2",1)
					.values(4,"2014-07-03 13:12:23","127.0.0.1",3)
					.values(5,"2014-07-03 13:12:23","127.0.0.1",4)
					.values(6,"2014-07-03 13:12:23","127.0.0.1",3)
					.values(7,"2014-07-03 13:12:23","127.0.0.3",1)
					.build());
}
