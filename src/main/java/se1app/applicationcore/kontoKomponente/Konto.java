package se1app.applicationcore.kontoKomponente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import se1app.applicationcore.util.KontoNrTyp;

@Entity
public class Konto {

	@Id
	private KontoNrTyp kontoNummer;
	
	private int kontoStand;
	
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="kontoNr")
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
}
