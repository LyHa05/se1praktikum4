package se1app.applicationcore.kontoKomponente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se1app.applicationcore.util.KontoNrTyp;

@Repository
public interface KontoRepository extends JpaRepository<Konto, Integer> {

	Optional<Konto> findByKontoNummer(KontoNrTyp kontoNr);
	
}
