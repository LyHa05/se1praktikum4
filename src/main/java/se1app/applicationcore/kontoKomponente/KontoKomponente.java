package se1app.applicationcore.kontoKomponente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KontoKomponente implements KontoKomponenteInterface{

	private KontoRepository kr; 
	private BuchungsPositionRepository bpr; 
	
	@Autowired
	public KontoKomponente(KontoRepository kontoRepository, BuchungsPositionRepository buchungsPositionRepository) {
		this.kr = kontoRepository;
		this.bpr = buchungsPositionRepository;
	}
	
	@Override
	public void ueberweise(String quellKontonummer, String zielKontonummer, int betrag)
			throws KontoNichtGefundenException, KontoNichtGedecktException {
		Konto quellKonto = getKonto(quellKontonummer);
		Konto zielKonto = getKonto(zielKontonummer);
		quellKonto.buche(-betrag);
		zielKonto.buche(betrag);
		
		
	}

	private Konto getKonto(String kontoNummer) {
		return kr.findByKontoNummer(kontoNummer);
	}
	
	
}
