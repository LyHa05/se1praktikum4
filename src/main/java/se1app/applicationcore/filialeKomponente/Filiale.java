package se1app.applicationcore.filialeKomponente;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import se1app.applicationcore.kontoKomponente.Konto;

@Entity
public class Filiale {
	
	@Id
	private int filialNr;

	private int anzahlBuchungen;
	
	@OneToMany
	private List<Konto> gefuehrteKonten;
	
	public Filiale() {}
	
	public int getFilialNr() {
		return filialNr;
	}
	
	public int getAnzahlBuchungen(){
		return anzahlBuchungen;
	}
}
