package se1app.applicationcore.kontoKomponente;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import se1app.applicationcore.ApplicationOhneGUI;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = ApplicationOhneGUI.class)
@ActiveProfiles("test")
public class BuchungsPositionTest {
	
	@Autowired
	private BuchungsPositionRepository buchungsPositionRepository;
	
	@Autowired
	private KontoRepository kontoRepository;
	
	private BuchungsPosition bp1;
	private BuchungsPosition bp2;
	private BuchungsPosition bp3;
	private BuchungsPosition bp4;
	
	private Konto k1;
	private Konto k2;
	
	@Before
	public void setUp() throws Exception {
		bp1 = new BuchungsPosition(-10);
		bp2 = new BuchungsPosition(10);
		buchungsPositionRepository.save(bp1);
		buchungsPositionRepository.save(bp2);
		bp3 = new BuchungsPosition(-5);
		bp4 = new BuchungsPosition(5);
		buchungsPositionRepository.save(bp3);
		buchungsPositionRepository.save(bp4);
		k1 = new Konto("000123");
		kontoRepository.save(k1);
		k2 = new Konto("000124");
		kontoRepository.save(k2);
	}

	@Test
	public void testFindAll() {
		List<BuchungsPosition> buchungen = buchungsPositionRepository.findAll();
		assertThat(buchungen).hasSize(4);
	}
	
	@Test
	public void testBuchungen() {
		k1.addBuchungsPosition(bp2);
		k1.addBuchungsPosition(bp4);
		assertTrue(15 == k1.getKontoStand());
	}

}
