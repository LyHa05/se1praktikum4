package se1app.applicationcore.kontoKomponente;

import java.util.List;

import javax.persistence.*;
import se1app.applicationcore.util.KontoNrTyp;

@Entity
public class Konto {

	@GeneratedValue
	@Id
	private int id;
	
	private KontoNrTyp kontoNummer;
	
	private int kontoStand;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="kontoNr")
	private List<BuchungsPosition> buchungsPositionen;
	
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

	public void buche(int betrag) throws KontoNichtGedecktException {
		if(betrag > 0 && (kontoStand + betrag) > 0) {
			kontoStand = kontoStand + betrag;
		} else {
			throw new KontoNichtGedecktException(kontoNummer.toString());
		}
		
	}
}
