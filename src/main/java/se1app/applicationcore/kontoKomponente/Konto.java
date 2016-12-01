package se1app.applicationcore.kontoKomponente;

import javax.persistence.Entity;
import se1app.applicationcore.util.KontoNrTyp;

@Entity
public class Konto {

	private KontoNrTyp kontoNummer;
	
	private int kontoStand;
	
	public Konto() {}
	
	public int getKontoStand() {
		return kontoStand;
	}
	
	public KontoNrTyp getKontoNummer() {
		return kontoNummer;
	}
	
	@Override
	public String toString() {
		return kontoNummer.toString() + " Kontostand: " + kontoStand;
	}
}
