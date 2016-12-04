package se1app.applicationcore.filialeKomponente;

import org.springframework.beans.factory.annotation.Autowired;

public class FilialeKomponente implements FilialeKomponenteInterface {

	@Autowired
	FilialeRepository filialeRepo;

	public FilialeKomponente(FilialeRepository filialeRepository) {
		this.filialeRepo = filialeRepository;
	}

	@Override
	public void erhoeheFilialeStatistik() {
		filialeRepo.findAll().get(0).incrementBuchungen();
	}
}
