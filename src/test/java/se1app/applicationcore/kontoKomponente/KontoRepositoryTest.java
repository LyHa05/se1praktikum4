package se1app.applicationcore.kontoKomponente;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.ApplicationOhneGUI;
import se1app.applicationcore.util.KontoNrTyp;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = ApplicationOhneGUI.class)
@ActiveProfiles("test")
public class KontoRepositoryTest {

	@Autowired
	private KontoRepository kontoRepository;
	
	private Konto k1;
	
	@Before
	public void setUp() throws Exception {
		k1 = new Konto("000123");
		kontoRepository.save(k1);
		Konto k2 = new Konto("000124");
		kontoRepository.save(k2);
		Konto k3 = new Konto("000125");
		kontoRepository.save(k3);
	}

	@Test
	public void testFindAll() {
		List<Konto> konten = kontoRepository.findAll();
		assertThat(konten).hasSize(3);
	}
	
	@Test
	public void testFindByKontoNummer() {
		KontoNrTyp knt = new KontoNrTyp("000123");
		Optional<Konto> konto = kontoRepository.findByKontoNummer(knt);
		assertThat(konto.isPresent());
		assertThat(konto.get().getKontoNummer().equals("000123"));
	}

}
