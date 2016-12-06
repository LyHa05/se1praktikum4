package se1app.applicationcore.kontoKomponente;

import java.util.List;

/**
 * Klasse implementiert Interface von Kontokomponente.
 * 
 * @author Lucas Anders, Lydia Pflug
 * @date 02.12.2016
 */
public interface KontoKomponenteInterface {

	/**
	 * Methode bucht Betrag von Quell- auf Zielkonto.
	 * 
	 * @param quellKontonummer
	 * @param zielKontonummer
	 * @param betrag
	 * @throws KontoNichtGefundenException
	 * @throws KontoNichtGedecktException
	 */
	void ueberweise(String quellKontonummer, String zielKontonummer, int betrag)
			throws KontoNichtGefundenException, KontoNichtGedecktException;

	/**
	 * Methode liefert alle Buchungspositionen eines Kontos.
	 * @param kontoNummer von dem Konto
	 * @return Liste mit Buchungspositionen
	 * @throws KontoNichtGefundenException
	 */
	List<BuchungsPosition> getAllBuchungsPositionen(String kontoNummer) throws KontoNichtGefundenException;

	/**
	 * Methode speichert Konto
	 * @param konto
	 */
	void kontoSpeichern(Konto konto);

	void newBuchungsPosition(Konto konto, BuchungsPosition newBuchungsPosition);

}
