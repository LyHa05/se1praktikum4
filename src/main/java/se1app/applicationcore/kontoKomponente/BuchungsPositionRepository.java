package se1app.applicationcore.kontoKomponente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchungsPositionRepository extends JpaRepository<BuchungsPosition, Integer>{

	BuchungsPosition findById(int id);
}
