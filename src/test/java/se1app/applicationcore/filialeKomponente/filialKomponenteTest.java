package se1app.applicationcore.filialeKomponente;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se1app.applicationcore.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class filialKomponenteTest {

	Filiale filiale;
	FilialeKomponente filialeKomponente;

	@Autowired
	private FilialeRepository filialeRepo;

	@Before
	public void setUp() {
		filiale = new Filiale();
		System.out.println(filiale.getId());
		filialeRepo.save(filiale);
		System.out.println(filiale.getId());
		filialeKomponente = new FilialeKomponente(filialeRepo);
	}

	@Test
	public void testFiliale() {
		Filiale filiale = new Filiale();
		filialeRepo.save(filiale);
		assertNotNull(filialeRepo.findAll().get(1));
	}

	@Test
	public void testErhoeheStatistik() {
		assertEquals(0, filialeRepo.getOne(filiale.getId()).getAnzahlBuchungen());

		filialeKomponente.erhoeheFilialeStatistik();

		assertEquals(1, filialeRepo.getOne(filiale.getId()).getAnzahlBuchungen());
	}

}
