package se1app.applicationcore.kontoKomponente;

import javax.persistence.*;

@Entity
public class BuchungsPosition {

	@GeneratedValue
	@Id
	private int id;
	
	private int gebuchterBetrag;

	public BuchungsPosition(int betrag) {
		gebuchterBetrag = betrag;
	}
	
	public BuchungsPosition() {}
	
	public int getId() {
		return id;
	}
	
	public int getGebuchterBetrag() {
		return gebuchterBetrag;
	}
}
