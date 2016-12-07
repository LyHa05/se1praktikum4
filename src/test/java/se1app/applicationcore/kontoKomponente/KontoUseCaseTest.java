package se1app.applicationcore.kontoKomponente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class KontoUseCaseTest {
	
	private KontoKomponenteInterface kontoKomponenteInterface;

	@Autowired
	private KontoRepository kontoRepository;
	
	@Autowired
	private BuchungsPositionRepository buchungsPositionRepository;
	
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
		
		kontoKomponenteInterface = new KontoUseCase(kontoRepository, buchungsPositionRepository); 
	}

	@Test
	public void testUberweisen() throws KontoNichtGefundenException, KontoNichtGedecktException {
		k1.addBuchungsPosition(bp2);
		assertTrue(10 == k1.getKontoStand());
		kontoKomponenteInterface.ueberweise("000123", "000124", 5);
		assertTrue(5 == k1.getKontoStand());
		assertTrue(5 == k2.getKontoStand());
	}
	
	@Test(expected = KontoNichtGedecktException.class)
	public void testUberweisenKontostandNull() throws KontoNichtGefundenException, KontoNichtGedecktException {
		kontoKomponenteInterface.ueberweise("000123", "000124", 5);
	}
	
	@Test(expected = KontoNichtGedecktException.class)
	public void testUberweisenKontostandDanachNegativ() throws KontoNichtGefundenException, KontoNichtGedecktException {
		k1.addBuchungsPosition(bp2);
		kontoKomponenteInterface.ueberweise("000123", "000124", 15);
	}
	
	@Test(expected = KontoNichtGefundenException.class)
	public void testKontoNichtGefunden() throws KontoNichtGefundenException, KontoNichtGedecktException {
		k1.addBuchungsPosition(bp2);
		kontoKomponenteInterface.ueberweise("000123", "000125", 5);
	}

}
