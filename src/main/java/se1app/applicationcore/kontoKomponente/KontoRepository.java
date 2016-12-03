package se1app.applicationcore.kontoKomponente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontoRepository extends JpaRepository<Konto, Integer> {

	Konto findByKontoNummer(String kontoNr);
}
