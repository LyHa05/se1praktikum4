package se1app.applicationcore.kontoKomponente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KontoUseCase implements KontoKomponenteInterface{

	private KontoRepository kr; 
	private BuchungsPositionRepository bpr; 
	
	@Autowired
	public KontoUseCase(KontoRepository kontoRepository, BuchungsPositionRepository buchungsPositionRepository) {
		this.kr = kontoRepository;
		this.bpr = buchungsPositionRepository;
	}
	
	@Override
	public void ueberweise(String quellKontonummer, String zielKontonummer, int betrag)
			throws KontoNichtGefundenException, KontoNichtGedecktException {
		Konto quellKonto = getKonto(quellKontonummer);
		Konto zielKonto = getKonto(zielKontonummer);
		BuchungsPosition bp1 = new BuchungsPosition(-betrag);
		BuchungsPosition bp2 = new BuchungsPosition(-betrag);
		quellKonto.buche(bp1.getGebuchterBetrag());
		zielKonto.buche(bp2.getGebuchterBetrag());
		newBuchungsPosition(quellKonto, bp1);
		newBuchungsPosition(zielKonto, bp2);
		
	}

	private Konto getKonto(String kontoNummer) throws KontoNichtGefundenException {
		Konto konto = kr.findByKontoNummer(kontoNummer);
		if (konto == null) {
			throw new KontoNichtGefundenException(kontoNummer);
		}
		return konto;
	}
	
	private void newBuchungsPosition(Konto konto, BuchungsPosition newBuchungsPosition) {
		bpr.save(newBuchungsPosition);
		konto.addBuchungsPosition(newBuchungsPosition);		
	}
}

