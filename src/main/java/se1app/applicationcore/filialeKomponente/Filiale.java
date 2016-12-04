package se1app.applicationcore.filialeKomponente;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import se1app.applicationcore.kontoKomponente.Konto;

@Entity
public class Filiale {

	@Id
	@GeneratedValue
	private int id;

	private int anzahlBuchungen;

	@OneToMany
	private List<Konto> gefuehrteKonten;

	public Filiale() {
		this.anzahlBuchungen = 0;
	}

	public int getId() {
		return id;
	}

	public int getAnzahlBuchungen() {
		return anzahlBuchungen;
	}

	public void incrementBuchungen() {
		anzahlBuchungen++;
	}

}
