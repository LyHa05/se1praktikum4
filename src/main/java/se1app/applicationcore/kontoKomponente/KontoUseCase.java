package se1app.applicationcore.kontoKomponente;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se1app.applicationcore.util.KontoNrTyp;

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
		BuchungsPosition bp2 = new BuchungsPosition(betrag);
		quellKonto.buche(bp1.getGebuchterBetrag());
		zielKonto.buche(bp2.getGebuchterBetrag());
		newBuchungsPosition(quellKonto, bp1);
		newBuchungsPosition(zielKonto, bp2);
		
	}

	private Konto getKonto(String kontoNummer) throws KontoNichtGefundenException {
		KontoNrTyp kontoNrTyp = new KontoNrTyp(kontoNummer);
		Optional<Konto> konto = kr.findByKontoNummer(kontoNrTyp);
		try {
			konto.get();
		} catch (NoSuchElementException e) {
			throw new KontoNichtGefundenException(kontoNummer);
		}

		return konto.get();
	}
	
	@Override
	public void newBuchungsPosition(Konto konto, BuchungsPosition newBuchungsPosition) {
		bpr.save(newBuchungsPosition);
		konto.addBuchungsPosition(newBuchungsPosition);
		kr.save(konto);
	}

	@Override
	public List<BuchungsPosition> getAllBuchungsPositionen(String kontoNummer) throws KontoNichtGefundenException {
		List<BuchungsPosition> buchungen = new ArrayList<>();
		Konto konto = getKonto(kontoNummer);
		buchungen.addAll(konto.getBuchungsPositionen());
		return buchungen;
	}

	@Override
	public void kontoSpeichern(Konto konto) {
		kr.save(konto);
	}
}

